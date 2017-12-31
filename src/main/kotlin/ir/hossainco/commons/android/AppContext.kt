@file:Suppress("unused")

package ir.hossainco.commons.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.os.Build.VERSION.SDK_INT
import android.support.annotation.RequiresApi

val appContext
	get() = internalContext ?: initAppContextWithReflection()

fun Context.useAsAppContext() {
	internalContext = this as? Application ?: this.applicationContext
}

/**
 * Lazily creates a device protected storage Context on Android N+ devices,
 * or initializes itself to [appContext] if the device runs Android M or an older version.
 * See [Direct Boot documentation](https://developer.android.com/training/articles/direct-boot.html)
 * to learn more.
 */
inline val directBootContext: Context
	get() = if (SDK_INT < 24) appContext else deviceProtectedStorageCtx.value


@SuppressLint("StaticFieldLeak")
private var internalContext: Context? = null

@SuppressLint("PrivateApi")
private fun initAppContextWithReflection(): Context {
	// Fallback, should only run once per non default process.
	val activityThread = Class.forName("android.app.ActivityThread")
	val context = activityThread.getDeclaredMethod("currentApplication").invoke(null) as Context
	internalContext = context
	return context
}

@PublishedApi
@RequiresApi(24)
internal val deviceProtectedStorageCtx = lazy(appContext::createDeviceProtectedStorageContext)
