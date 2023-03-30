package com.example.kotlin_api_calling.RequestModels

import com.google.gson.annotations.SerializedName

data class PreEnrollModel (
    @SerializedName("Message"    ) var Message    : PreEnrollRequestMessage? = PreEnrollRequestMessage(),
    @SerializedName("Status"     ) var Status     : Int?     = null,
    @SerializedName("StatusCode" ) var StatusCode : Int?     = null)
data class PreEnrollRequestMessage (

    @SerializedName("AlternativeIdentifiers" ) var AlternativeIdentifiers : String?        = null,
    @SerializedName("Country"                ) var Country                : String?        = null,
    @SerializedName("CryptoSuite"            ) var CryptoSuite            : Int?           = null,
    @SerializedName("DeviceIdentifier"       ) var DeviceIdentifier       : String?        = null,
    @SerializedName("MDN"                    ) var MDN                    : String?        = null,
    @SerializedName("Random"                 ) var Random                 : ArrayList<Int> = arrayListOf()

)