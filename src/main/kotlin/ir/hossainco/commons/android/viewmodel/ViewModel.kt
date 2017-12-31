@file:Suppress("unused")

/* some source inspired from: https://proandroiddev.com/kotlin-delegates-in-android-development-part-2-2c15c11ff438 */

package ir.hossainco.commons.android.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import ir.hossainco.commons.types.Provider
import ir.hossainco.commons.types.SingleProvider

@Suppress("UNCHECKED_CAST")
inline fun <VM : ViewModel> viewModelFactory(crossinline provider: Provider<VM>) =
	object : ViewModelProvider.Factory {
		override fun <T : ViewModel> create(clazz: Class<T>) = provider() as T
	}

@Suppress("UNCHECKED_CAST")
inline fun <VM : ViewModel, P> viewModelFactory(crossinline provider: SingleProvider<VM, P>, p: P) =
	object : ViewModelProvider.Factory {
		override fun <T : ViewModel> create(clazz: Class<T>) = provider(p) as T
	}


inline fun <reified VM : ViewModel> Fragment.viewModelProvider(crossinline provider: Provider<VM>)
	= ViewModelProviders.of(this, viewModelFactory(provider)).get(VM::class.java)

inline fun <reified VM : ViewModel> FragmentActivity.viewModelProvider(crossinline provider: Provider<VM>)
	= ViewModelProviders.of(this, viewModelFactory(provider)).get(VM::class.java)


inline fun <reified VM : ViewModel> Fragment.viewModelSingleProvider(crossinline provider: SingleProvider<VM, Fragment>)
	= ViewModelProviders.of(this, viewModelFactory(provider, this)).get(VM::class.java)

inline fun <reified VM : ViewModel> FragmentActivity.viewModelSingleProvider(crossinline provider: SingleProvider<VM, FragmentActivity>)
	= ViewModelProviders.of(this, viewModelFactory(provider, this)).get(VM::class.java)


inline fun <reified VM : ViewModel> Fragment.viewModelProviderLazy(mode: LazyThreadSafetyMode = LazyThreadSafetyMode.NONE, crossinline provider: Provider<VM>)
	= lazy(mode) { ViewModelProviders.of(this, viewModelFactory(provider)).get(VM::class.java) }

inline fun <reified VM : ViewModel> FragmentActivity.viewModelProviderLazy(mode: LazyThreadSafetyMode = LazyThreadSafetyMode.NONE, crossinline provider: Provider<VM>)
	= lazy(mode) { ViewModelProviders.of(this, viewModelFactory(provider)).get(VM::class.java) }


inline fun <reified VM : ViewModel> Fragment.viewModelSingleProviderLazy(mode: LazyThreadSafetyMode = LazyThreadSafetyMode.NONE, crossinline provider: SingleProvider<VM, Fragment>)
	= lazy(mode) { ViewModelProviders.of(this, viewModelFactory(provider, this)).get(VM::class.java) }

inline fun <reified VM : ViewModel> FragmentActivity.viewModelSingleProviderLazy(mode: LazyThreadSafetyMode = LazyThreadSafetyMode.NONE, crossinline provider: SingleProvider<VM, FragmentActivity>)
	= lazy(mode) { ViewModelProviders.of(this, viewModelFactory(provider, this)).get(VM::class.java) }
