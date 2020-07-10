package com.ayokunlepaul.channel.utils.layoutmanager

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager

class GridLayoutManagerWrapper constructor(context: Context, span: Int) :
    GridLayoutManager(context, span) {

    override fun supportsPredictiveItemAnimations(): Boolean {
        return false
    }
}