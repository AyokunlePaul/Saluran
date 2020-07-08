package com.ayokunlepaul.local.pref

import android.content.Context
import com.ayokunlepaul.local.utils.SaluranLocalConstants
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SaluranSharedPrefImpl @Inject constructor(
    @ApplicationContext context: Context
) : SaluranSharedPref {

    private val saluranSharedPref = context.getSharedPreferences(
        SaluranLocalConstants.SALURAN_SHARED_PREFERENCE,
        Context.MODE_PRIVATE
    )

    override fun setBoolean(key: String) {
        TODO("Not yet implemented")
    }

    override fun getBoolean(key: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun setString(key: String) {
        TODO("Not yet implemented")
    }

    override fun getString(key: String): String {
        TODO("Not yet implemented")
    }

    override fun setInt(key: String) {
        TODO("Not yet implemented")
    }

    override fun getInt(key: String): Int {
        TODO("Not yet implemented")
    }
}