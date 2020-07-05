package com.ayokunlepaul.channel

data class BaseModel <out DATA> (
    val data: DATA,
    val message: String
)