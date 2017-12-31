@file:Suppress("unused")

package ir.hossainco.commons.android.livedata

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class LiveDataDelegate<T : Any>(
	initialState: T,
	private val liveData: MutableLiveData<T> = MutableLiveData()
) : ReadWriteProperty<Any, T> {

	init {
		liveData.value = initialState
	}

	fun observe(owner: LifecycleOwner, observer: (T) -> Unit)
		= liveData.observeNotnull(owner, observer)

	override operator fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
		liveData.value = value
	}

	override operator fun getValue(thisRef: Any, property: KProperty<*>): T
		= liveData.value!!
}
