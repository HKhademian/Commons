@file:Suppress("unused")

package ir.hossainco.commons.android

import ir.hossainco.commons.Random.randomInt
import android.os.Build
import android.view.View

object Random {
	fun generateViewId()
		= if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) View.generateViewId() else randomInt()
}
