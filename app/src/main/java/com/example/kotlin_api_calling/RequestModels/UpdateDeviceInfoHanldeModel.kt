package com.example.kotlin_api_calling.RequestModels

import com.google.gson.annotations.SerializedName

data class UpdateDeviceInfoHanldeModel ( @SerializedName("Message" ) var Message : UpdateDeviceInfoMessage? = UpdateDeviceInfoMessage())


data class UpdateDeviceInfoMessage (

    @SerializedName("DeviceInfo" ) var DeviceInfo : String?        = null,
    @SerializedName("Token"      ) var Token      : ArrayList<Int> = arrayListOf()

)
