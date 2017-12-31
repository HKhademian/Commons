package ir.hossainco.rxbus2

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject

/** Simple Rx Event Bus */
open class RxBus {
	companion object INSTANCE : RxBus() {
		@JvmStatic
		val instance
			get() = INSTANCE
	}

	/** Used to hold all subscriptions for Bus events and unsubscribe properly when needed. */
	private val disposableMap by lazy<HashMap<Any, CompositeDisposable>>(::HashMap)

	/** Avoid using this property directly, exposed only because it's used in inline fun */
	private val bus = PublishSubject.create<Any>()!!

	/** Sends an event to Bus. Can be called from any thread */
	fun send(event: Any)
		= bus.onNext(event)

	/** Subscribes for events of certain type T. Can be called from any thread */
	fun <T> observe(clazz: Class<T>): Observable<T>
		= bus.ofType(clazz)

	inline fun <reified T> observe()
		= observe(T::class.java)

	fun register(subscriber: Any, disposable: Disposable) {
		val compositeDisposable = disposableMap[subscriber] ?: CompositeDisposable()
		compositeDisposable.add(disposable)
		disposableMap[subscriber] = compositeDisposable
	}

	/**
	 * Unregisters subscriber from Bus events.
	 * Calls unsubscribe method of your subscriptions
	 * @param subscriber subscriber to unregister
	 */
	fun unregister(subscriber: Any) {
		val compositeDisposable = disposableMap[subscriber]
		if (compositeDisposable == null) {
			//Log.w(TAG, "Trying to unregister subscriber that wasn't registered")
		} else {
			compositeDisposable.clear()
			disposableMap.remove(subscriber)
		}
	}
}
