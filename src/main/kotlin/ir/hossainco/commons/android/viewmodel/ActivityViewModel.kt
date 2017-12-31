package ir.hossainco.commons.android.viewmodel

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application

@Suppress("UNCHECKED_CAST", "MemberVisibilityCanPrivate")
@SuppressLint("StaticFieldLeak")
open class ActivityViewModel<out APPLICATION : Application, out ACTIVITY : Activity>
(val activity: ACTIVITY)
	: ApplicationViewModel<APPLICATION>(activity.application as APPLICATION) {
	override val context: ACTIVITY
		get() = activity
}
