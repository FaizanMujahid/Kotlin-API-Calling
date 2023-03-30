package com.example.kotlin_api_calling.ResponseModels
import com.google.gson.annotations.SerializedName

data class GetCertResponseModel (  @SerializedName("Message" ) var Message : GetCertMessage? = GetCertMessage()
)

data class GetCertMessage (

    @SerializedName("Certificate" ) var Certificate : ArrayList<Int> = arrayListOf()

)