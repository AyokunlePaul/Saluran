package com.ayokunlepaul.local.utils

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

inline fun <reified T : RoomDatabase> database(
    context: Context,
    block: RoomDatabase.Builder<T>.() -> Unit
): T {
    return Room.databaseBuilder(
        context, T::class.java,
        SaluranLocalConstants.SALURAN_DATABASE_NAME
    ).apply(block).build()
}