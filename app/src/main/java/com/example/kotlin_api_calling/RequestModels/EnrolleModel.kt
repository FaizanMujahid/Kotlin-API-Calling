package com.example.kotlin_api_calling.RequestModels

import com.google.gson.annotations.SerializedName

data class EnrolleModel ( @SerializedName("Message"    ) var Message    : EnrolleMessage? = EnrolleMessage(),
                          @SerializedName("Status"     ) var Status     : Int?     = null,
                          @SerializedName("StatusCode" ) var StatusCode : Int?     = null)


data class EnrolleMessage (

    @SerializedName("CryptoSuite" ) var CryptoSuite : Int?           = null,
    @SerializedName("Id"          ) var Id          : String?        = null,
    @SerializedName("PinHash"     ) var PinHash     : ArrayList<Int> = arrayListOf(),
    @SerializedName("Random"      ) var Random      : ArrayList<Int> = arrayListOf()

)