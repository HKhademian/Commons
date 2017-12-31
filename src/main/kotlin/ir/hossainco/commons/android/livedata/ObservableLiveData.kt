package ir.hossainco.commons.android.livedata

import android.arch.lifecycle.LiveData
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ObservableLiveData<T>
(private val observable: Observable<T>, private val subscribeOn: Scheduler = Schedulers.io())
	: LiveData<T>() {
	private var disposable: Disposable? = null

	override fun onActive() {
		disposable = observable
			.subscribeOn(subscribeOn)
			.subscribe(this::postValue)
		super.onActive()
	}

	override fun onInactive() {
		disposable?.dispose()
		super.onInactive()
	}
}
