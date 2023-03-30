package com.example.kotlin_api_calling.ResponseModels

import com.google.gson.annotations.SerializedName

data class SessionTokenResponseModel (  @SerializedName("Message" ) var Message : SessionTokenResponseMessage? = SessionTokenResponseMessage()
)

data class SessionTokenResponseMessage (

    @SerializedName("EncryptedToken" ) var EncryptedToken : ArrayList<Int> = arrayListOf(),
    @SerializedName("Random"         ) var Random         : ArrayList<Int> = arrayListOf()

)