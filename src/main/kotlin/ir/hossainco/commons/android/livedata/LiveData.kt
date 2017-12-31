@file:Suppress("unused")

package ir.hossainco.commons.android.livedata

import android.arch.lifecycle.*

inline fun <T> LiveData<T>.observe(owner: LifecycleOwner, crossinline observe: (data: T) -> Unit)
	= this.observe(owner, Observer { it?.let(observe) })

inline fun <T> LiveData<T>.observeNotnull(owner: LifecycleOwner, crossinline observe: (data: T) -> Unit)
	= this.observe(owner, Observer { observe(it!!) })

infix fun <A, B> LiveData<A>.zip(b: LiveData<B>): LiveData<Pair<A, B>>
	= zipLiveData(this, b)

infix fun <A, B> LiveData<A>.map(function: (A) -> B): LiveData<B>
	= Transformations.map(this, function)

infix fun <A, B> LiveData<A>.switchMap(function: (A) -> LiveData<B>): LiveData<B>
	= Transformations.switchMap(this, function)

fun <A, B> zipLiveData(a: LiveData<A>, b: LiveData<B>): LiveData<Pair<A, B>> =
	MediatorLiveData<Pair<A, B>>().apply {
		var lastA: A? = null
		var lastB: B? = null

		fun update() {
			val localLastA = lastA
			val localLastB = lastB
			if (localLastA != null && localLastB != null)
				this.value = Pair(localLastA, localLastB)
		}

		addSource(a) {
			lastA = it
			update()
		}
		addSource(b) {
			lastB = it
			update()
		}
	}


