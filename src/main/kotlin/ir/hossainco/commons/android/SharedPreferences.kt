package ir.hossainco.commons.android

import android.content.SharedPreferences

inline fun SharedPreferences.edit(block: SharedPreferences.Editor.() -> Unit) {
	val editor = edit()
	editor.block()
	editor.apply()
}
