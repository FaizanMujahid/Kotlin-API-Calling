package com.example.kotlin_api_calling.ResponseModels

import com.google.gson.annotations.SerializedName

data class UpdateDeviceInfoResponseModel (
    @SerializedName("Message"    ) var Message    : UpdateDeviceInfoMessageRespons? = UpdateDeviceInfoMessageRespons(),
    @SerializedName("Status"     ) var Status     : Int?     = null,
    @SerializedName("StatusCode" ) var StatusCode : Int?     = null
)

data class UpdateDeviceInfoMessageRespons(
    @SerializedName("Updated" ) var Updated : Boolean? = null

)