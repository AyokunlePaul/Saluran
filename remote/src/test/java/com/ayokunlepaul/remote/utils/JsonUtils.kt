package com.ayokunlepaul.remote.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

object JsonUtils {
    /**
     * Helper function which will load JSON from
     * the path specified
     *
     * @param path : Path of JSON file
     * @return json : JSON from file at given path
     */
    fun getJson(path: String): String {
        // Load the JSON response
        val uri = this.javaClass.classLoader?.getResource(path)
        val file = File(uri?.path ?: "")
        return String(file.readBytes())
    }

    inline fun <reified T> parseJson(value: String): T {
        return Gson().fromJson(value, T::class.java)
    }

    inline fun <reified T> parseJsonList(value: String): List<T> {
        return Gson().fromJson(value, object : TypeToken<List<T>>() {}.type)
    }
}