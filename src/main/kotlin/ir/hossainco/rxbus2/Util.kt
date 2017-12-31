package ir.hossainco.rxbus2

import io.reactivex.disposables.Disposable


/**
 * Registers the subscription to correctly unregister it later to avoid memory leaks
 * @param subscriber subscriber object that owns this subscription
 */
fun Disposable.registerInBus(subscriber: Any, bus: RxBus = RxBus) =
	bus.register(subscriber, this)
