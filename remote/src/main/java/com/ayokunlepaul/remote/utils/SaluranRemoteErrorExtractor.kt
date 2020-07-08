package com.ayokunlepaul.remote.utils

import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import java.net.*

object SaluranRemoteErrorExtractor {

    fun extractErrorMessage(throwable: Throwable): String {
        return when (throwable) {
            is ConnectException -> SaluranRemoteErrorMessages.CONNECT_EXCEPTION
            is UnknownHostException -> SaluranRemoteErrorMessages.UNKNOWN_HOST_EXCEPTION
            is SocketTimeoutException -> SaluranRemoteErrorMessages.SOCKET_TIME_OUT_EXCEPTION
            is UnknownServiceException -> throwable.localizedMessage ?: SaluranRemoteErrorMessages.UNKNOWN_NETWORK_EXCEPTION
            is ProtocolException -> SaluranRemoteErrorMessages.PROTOCOL_EXCEPTION
            is HttpException -> {
                return if (throwable.code() == 403) {
                    val message = throwable.message()
                    return message ?: SaluranRemoteErrorMessages.FORBIDDEN_EXCEPTION
                } else try {
                    val response = throwable.response()
                    val json = JSONObject(response?.errorBody()?.string()!!)
                    if (json.has("status")) json["status"] as String
                    else json["error"] as String
                } catch (e1: JSONException) {
                    SaluranRemoteErrorMessages.UNKNOWN_NETWORK_EXCEPTION
                } catch (e1: IOException) {
                    SaluranRemoteErrorMessages.UNKNOWN_NETWORK_EXCEPTION
                }
            }
            else -> SaluranRemoteErrorMessages.UNKNOWN_NETWORK_EXCEPTION
        }
    }
}