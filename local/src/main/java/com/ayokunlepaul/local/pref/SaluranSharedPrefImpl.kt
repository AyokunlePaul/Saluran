package com.ayokunlepaul.local.pref

import android.content.Context
import androidx.core.content.edit
import com.ayokunlepaul.local.BuildConfig
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SaluranSharedPrefImpl @Inject constructor(
    @ApplicationContext context: Context
) : SaluranSharedPref {

    private val saluranSharedPref = context.getSharedPreferences(
        BuildConfig.SALURAN_SHARED_PREFERENCE,
        Context.MODE_PRIVATE
    )

    override fun setBoolean(key: String, value: Boolean) = saluranSharedPref.edit {
        putBoolean(key, value)
    }

    override fun getBoolean(key: String): Boolean = saluranSharedPref.getBoolean(key, false)

    override fun setString(key: String, value: String) = saluranSharedPref.edit {
        putString(key, value)
    }

    override fun getString(key: String): String = saluranSharedPref.getString(key, null) ?: ""

    override fun setInt(key: String, value: Int) = saluranSharedPref.edit {
        putInt(key, value)
    }

    override fun getInt(key: String): Int = saluranSharedPref.getInt(key, 0)
}