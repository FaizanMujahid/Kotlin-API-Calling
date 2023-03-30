package com.example.kotlin_api_calling.ResponseModels

import com.google.gson.annotations.SerializedName

data class SessionHanldeResponseModel (

    @SerializedName("Message"    ) var Message    : String? = null,
    @SerializedName("Status"     ) var Status     : Int?    = null,
    @SerializedName("StatusCode" ) var StatusCode : Int?    = null

)