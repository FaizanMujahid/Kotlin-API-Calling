package com.example.kotlin_api_calling.RequestModels

import com.google.gson.annotations.SerializedName

data class SessionTokenModel(
    @SerializedName("Message"    ) var Message    : SessionTokenMessage? = SessionTokenMessage(),
    @SerializedName("Status"     ) var Status     : Int?     = null,
    @SerializedName("StatusCode" ) var StatusCode : Int?     = null)

data class SessionTokenMessage (

    @SerializedName("CryptoSuite" ) var CryptoSuite : Int?    = null,
    @SerializedName("Uuid"        ) var Uuid        : String? = null

)