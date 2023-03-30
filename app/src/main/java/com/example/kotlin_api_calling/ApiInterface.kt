package com.example.kotlin_api_calling

import com.example.kotlin_api_calling.RequestModels.*
import com.example.kotlin_api_calling.ResponseModels.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/management/SessionHandle")
    suspend fun sessionHandleAPICalling(@Body sessionHanldeModel: SessionHanldeModel): Response<SessionHanldeResponseModel>

    @POST("/management/UpdateDeviceInfoXml")
    suspend fun  updateDeviceInfoXmlAPICalling(@Body updateDeviceInfo: UpdateDeviceInfoHanldeModel): Response<UpdateDeviceInfoResponseModel>

    @POST("/management/SessionToken")
    suspend fun  sessionTokenAPICalling(@Body sessionTokenModel: SessionTokenModel): Response<SessionTokenResponseModel>

    @POST("/enrollment/Enroll")
    suspend fun  enrollAPICalling(@Body enrolleModel: EnrolleModel): Response<EnrollResponseModel>

    @POST("/preenrollment/PreEnroll")
    suspend fun  preEnrollAPICalling(@Body preEnrollModel: PreEnrollModel): Response<PreEnrollResponseModel>

    @POST("/pki/GetCert")
    suspend fun  getCertAPICalling(@Body getCertModel: GetCertModel): Response<GetCertResponseModel>

}