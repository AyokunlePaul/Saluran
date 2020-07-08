package com.ayokunlepaul.data.utils.errors

class InvalidParameterException(
    argument: String
) : Throwable("Invalid parameter type: $argument must not be null")