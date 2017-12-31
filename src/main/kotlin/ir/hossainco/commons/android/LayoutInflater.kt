package ir.hossainco.commons.android

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * @param attachToRoot should be explicitly false if used for a [RecyclerView] item, but the
 * default (true) can left as is for most other cases.
 *
 * @see LayoutInflater.inflate
 */
@Suppress("UNCHECKED_CAST")
fun <V : View> ViewGroup.inflate(@LayoutRes resource: Int, attachToRoot: Boolean = true)
	= LayoutInflater.from(context).inflate(resource, this, attachToRoot) as V

/**
 * Made to inflate itemViews for usage in a [RecyclerView].
 */
fun <V : View> ViewGroup.inflateItem(@LayoutRes resource: Int)
	= inflate<V>(resource, false)
