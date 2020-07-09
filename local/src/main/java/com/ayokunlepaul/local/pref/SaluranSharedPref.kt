package com.ayokunlepaul.local.pref

interface SaluranSharedPref {

    fun setBoolean(key: String, value: Boolean)

    fun getBoolean(key: String): Boolean

    fun setString(key: String, value: String)

    fun getString(key: String): String

    fun setInt(key: String, value: Int)

    fun getInt(key: String): Int
}