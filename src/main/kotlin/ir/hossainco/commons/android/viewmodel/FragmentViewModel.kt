package ir.hossainco.commons.android.viewmodel

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.app.Fragment

@Suppress("UNCHECKED_CAST", "MemberVisibilityCanPrivate", "CanBeParameter")
@SuppressLint("StaticFieldLeak")
open class FragmentViewModel<out APPLICATION : Application, out ACTIVITY : Activity, out FRAGMENT : Fragment>
(val fragment: FRAGMENT)
	: ActivityViewModel<APPLICATION, ACTIVITY>(fragment.activity as ACTIVITY)
