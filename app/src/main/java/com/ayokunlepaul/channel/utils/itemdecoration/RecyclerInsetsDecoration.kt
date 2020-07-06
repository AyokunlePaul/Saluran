package com.ayokunlepaul.channel.utils.itemdecoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class RecyclerInsetsDecoration : ItemDecoration {
    private var mLeftInsets: Int
    private var mTopInsets: Int
    private var mRightInsets: Int
    private var mBottomInsets: Int
    private var ignoreFirstChild: Boolean

    constructor(mInsets: Int, ignoreFirstChild: Boolean = false) {
        mLeftInsets = mInsets
        mTopInsets = mInsets
        mRightInsets = mInsets
        mBottomInsets = mInsets
        this.ignoreFirstChild = ignoreFirstChild
    }

    constructor(mVerticalInsets: Int, mHorizontalInsets: Int, ignoreFirstChild: Boolean = false) {
        mLeftInsets = mHorizontalInsets
        mTopInsets = mVerticalInsets
        mRightInsets = mHorizontalInsets
        mBottomInsets = mVerticalInsets
        this.ignoreFirstChild = ignoreFirstChild
    }

    constructor(
        mLeftInsets: Int,
        mTopInsets: Int,
        mRightInsets: Int,
        mBottomInsets: Int,
        ignoreFirstChild: Boolean = false
    ) {
        this.mLeftInsets = mLeftInsets
        this.mTopInsets = mTopInsets
        this.mRightInsets = mRightInsets
        this.mBottomInsets = mBottomInsets
        this.ignoreFirstChild = ignoreFirstChild
    }

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        if (ignoreFirstChild && parent.getChildAdapterPosition(view) == 0) {
            return
        }
        outRect.apply {
            left = mLeftInsets
            right = mRightInsets
            top = mTopInsets
            bottom = mBottomInsets
        }
    }
}