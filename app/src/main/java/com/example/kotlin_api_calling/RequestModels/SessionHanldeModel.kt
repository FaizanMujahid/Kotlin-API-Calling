package com.example.kotlin_api_calling.RequestModels

import com.google.gson.annotations.SerializedName

data class Message (
    @SerializedName("Token")
    var token: ArrayList<Int>? = null
)

data class SessionHanldeModel (
    @SerializedName("Message")
    var message: Message? = null,

    @SerializedName("Status")
    var status :Int= 0,

    @SerializedName("StatusCode")
    var statusCode :Int= 0
)