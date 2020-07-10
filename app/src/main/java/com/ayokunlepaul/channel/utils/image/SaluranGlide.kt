package com.ayokunlepaul.channel.utils.image

import android.widget.ImageView
import androidx.annotation.DrawableRes

interface SaluranGlide {

    fun loadImage(view: ImageView, @DrawableRes placeHolder: Int)
}