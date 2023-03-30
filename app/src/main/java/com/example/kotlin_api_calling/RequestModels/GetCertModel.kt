package com.example.kotlin_api_calling.RequestModels

import com.google.gson.annotations.SerializedName

data class GetCertModel (
    @SerializedName("Message"    ) var Message    : GetCertRequestMessage? = GetCertRequestMessage(),
    @SerializedName("Status"     ) var Status     : Int?     = null,
    @SerializedName("StatusCode" ) var StatusCode : Int?     = null
)

data class  GetCertRequestMessage (

    @SerializedName("Format" ) var Format : Int? = null

)