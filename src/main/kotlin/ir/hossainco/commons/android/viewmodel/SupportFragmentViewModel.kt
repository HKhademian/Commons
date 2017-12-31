package ir.hossainco.commons.android.viewmodel

import android.app.Application
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

@Suppress("UNCHECKED_CAST", "MemberVisibilityCanPrivate", "CanBeParameter")
open class SupportFragmentViewModel<out APPLICATION : Application, out ACTIVITY : FragmentActivity, out FRAGMENT : Fragment>
(val fragment: FRAGMENT)
	: ActivityViewModel<APPLICATION, ACTIVITY>(fragment.activity as ACTIVITY)
