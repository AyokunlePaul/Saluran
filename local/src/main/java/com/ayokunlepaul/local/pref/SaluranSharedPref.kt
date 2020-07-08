package com.ayokunlepaul.local.pref

interface SaluranSharedPref {

    fun setBoolean(key: String)

    fun getBoolean(key: String): Boolean

    fun setString(key: String)

    fun getString(key: String): String

    fun setInt(key: String)

    fun getInt(key: String): Int
}