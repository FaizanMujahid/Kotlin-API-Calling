package com.example.kotlin_api_calling.ResponseModels

import com.google.gson.annotations.SerializedName

data class EnrollResponseModel (
    @SerializedName("Message"    ) var Message    : EnrollResponseMessage? = EnrollResponseMessage(),
    @SerializedName("Status"     ) var Status     : Int?     = null,
    @SerializedName("StatusCode" ) var StatusCode : Int?     = null
)

data class EnrollResponseMessage (

    @SerializedName("AlternateIdentifier" ) var AlternateIdentifier : String?        = null,
    @SerializedName("Hash"                ) var Hash                : ArrayList<Int> = arrayListOf(),
    @SerializedName("Key"                 ) var Key                 : ArrayList<Int> = arrayListOf(),
    @SerializedName("Uuid"                ) var Uuid                : String?        = null

)
