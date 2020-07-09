package com.ayokunlepaul.channel.utils.layoutmanager

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager

class LinearLayoutManagerWrapper constructor(context: Context) : LinearLayoutManager(context) {

    override fun supportsPredictiveItemAnimations(): Boolean {
        return false
    }
}