package ir.hossainco.commons.android.typesaferecyclerview;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import ir.hossainco.commons.android.LayoutInflaterKt;

/**
 * Type-safe version of {@link RecyclerView.ViewHolder}.
 */
@SuppressWarnings("WeakerAccess")
public class ViewHolder<V extends View> extends RecyclerView.ViewHolder {

	/**
	 * You can access this typed field instead of casting {@link RecyclerView.ViewHolder#itemView}.
	 */
	public final V itemView;

	/**
	 * Creates ViewHolder from the provided View.
	 * @see #ViewHolder(int, ViewGroup)
	 */
	public ViewHolder(final V itemView) {
		super(itemView);
		this.itemView = itemView;
	}

	/**
	 * Creates a ViewHolder from a layout resource id.
	 *
	 * @param layoutResId ID for an XML layout resource to load (e.g., R.layout.main_page)
	 * @param parent      pass the first argument received in
	 *                    {@link RecyclerView.Adapter#onCreateViewHolder(ViewGroup, int)}
	 */
	public ViewHolder(@LayoutRes final int layoutResId, final ViewGroup parent) {
		this(LayoutInflaterKt.inflateItem(parent, layoutResId));
	}
}
