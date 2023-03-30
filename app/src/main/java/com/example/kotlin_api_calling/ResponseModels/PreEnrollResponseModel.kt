package com.example.kotlin_api_calling.ResponseModels

import com.google.gson.annotations.SerializedName

data class PreEnrollResponseModel ( @SerializedName("Message"    ) var Message    : PreEnrollMessage? = PreEnrollMessage(),
                               @SerializedName("Status"     ) var Status     : Int?     = null,
                               @SerializedName("StatusCode" ) var StatusCode : Int?     = null
)

data class PreEnrollMessage (

    @SerializedName("AnchorUrl"    ) var AnchorUrl    : String?        = null,
    @SerializedName("UrlSignature" ) var UrlSignature : ArrayList<Int> = arrayListOf()

)