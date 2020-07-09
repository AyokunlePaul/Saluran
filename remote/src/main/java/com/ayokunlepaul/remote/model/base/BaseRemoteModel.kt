package com.ayokunlepaul.remote.model.base

data class BaseRemoteModel<out DATA>(
    val data: DATA
)