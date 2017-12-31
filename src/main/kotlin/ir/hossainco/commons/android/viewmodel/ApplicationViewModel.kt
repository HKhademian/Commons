package ir.hossainco.commons.android.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.content.Context

@SuppressLint("StaticFieldLeak")
open class ApplicationViewModel<out APPLICATION : Application>
(val app: APPLICATION)
	: AndroidViewModel(app) {
	val applicationContext
		get() = app

	open val context: Context
		get() = app
}
