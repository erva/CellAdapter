package io.techery.sample;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {

	private Drawable mDivider;

	public DividerItemDecoration(Context context) {
		final TypedArray a = context.obtainStyledAttributes(new int [] { android.R.attr.listDivider });
		mDivider = a.getDrawable(0);
		a.recycle();
	}

	public DividerItemDecoration(Drawable divider) { mDivider = divider; }

	public DividerItemDecoration (Context context, @DrawableRes int drawableId) {
		mDivider = ResourcesCompat.getDrawable(context.getResources(), drawableId, null);
	}

	@Override
	public void getItemOffsets (Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
		super.getItemOffsets(outRect, view, parent, state);
		if (mDivider == null) return;
		if (parent.getChildAdapterPosition(view) < 1) return;

		if (getOrientation(parent) == LinearLayoutManager.VERTICAL) outRect.top = mDivider.getIntrinsicHeight();
		else outRect.left = mDivider.getIntrinsicWidth();
	}

	@Override
	public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
		if (mDivider == null) { super.onDrawOver(c, parent, state); return; }

		if (getOrientation(parent) == LinearLayoutManager.VERTICAL) {
			final int left = parent.getPaddingLeft();
			final int right = parent.getWidth() - parent.getPaddingRight();
			final int childCount = parent.getChildCount();

			for (int i=1; i < childCount; i++) {
				final View child = parent.getChildAt(i);
				final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
				final int size = mDivider.getIntrinsicHeight();
				final int top = child.getTop() - params.topMargin;
				final int bottom = top + size;
				mDivider.setBounds(left, top, right, bottom);
				mDivider.draw(c);
			}
		} else { //horizontal
			final int top = parent.getPaddingTop();
			final int bottom = parent.getHeight() - parent.getPaddingBottom();
			final int childCount = parent.getChildCount();

			for (int i=1; i < childCount; i++) {
				final View child = parent.getChildAt(i);
				final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
				final int size = mDivider.getIntrinsicWidth();
				final int left = child.getLeft() - params.leftMargin;
				final int right = left + size;
				mDivider.setBounds(left, top, right, bottom);
				mDivider.draw(c);
			}
		}
	}

	private int getOrientation(RecyclerView parent) {
		if (parent.getLayoutManager() instanceof LinearLayoutManager) {
			LinearLayoutManager layoutManager = (LinearLayoutManager) parent.getLayoutManager();
			return layoutManager.getOrientation();
		} else throw new IllegalStateException("DividerItemDecoration can only be used with a LinearLayoutManager.");
	}
}