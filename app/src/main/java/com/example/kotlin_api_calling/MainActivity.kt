package com.example.kotlin_api_calling

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.kotlin_api_calling.RequestModels.*
import com.example.kotlin_api_calling.ResponseModels.PreEnrollMessage
import com.example.kotlin_api_calling.ResponseModels.UserModel
import org.json.JSONException
import java.nio.charset.Charset


class MainActivity : AppCompatActivity() {
    private var requestQueue: RequestQueue? = null
    private var userList = ArrayList<UserModel>()
    private lateinit var customAdapter: CustomAdapter
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        requestQueue = Volley.newRequestQueue(this)
        jsonParse()
        btn1.setOnClickListener { certRetrofitCall() }
        btn2.setOnClickListener { enrollRetrofitCall() }
        btn3.setOnClickListener { preEnrollRetrofitCall()}
        btn4.setOnClickListener { sessionTokenRetrofitCall()}
        btn5.setOnClickListener { UpdateDeviceInfoXmlRetrofitCall()}
        btn6.setOnClickListener { sessionHandleRetrofitCall() }
    }

    private fun sessionTokenRetrofitCall() {
        var retrofit = RetrofitClient.getInstance()
        var apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                val sessionTokenMessage = SessionTokenMessage(2,"5ffcee42-6d56-4e4b-a6ca-e6aca49fe0e4")
                val sessionTokenModel = SessionTokenModel(sessionTokenMessage,0,0)
                val response = apiInterface.sessionTokenAPICalling(sessionTokenModel)
                if (response.isSuccessful()) {
                    //your code for handaling success response
                    Toast.makeText(
                        this@MainActivity,
                        response.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        response.errorBody().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }catch (Ex:Exception){
                Log.e("Error",Ex.localizedMessage)
            }
        }
    }

    private fun preEnrollRetrofitCall() {
        var retrofit = RetrofitClient.getInstance()
        var apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                var Random: ArrayList<Int> = arrayListOf(74,181,17,120,197,61,185,182,123,139,11,98,14,252,150)
                val preEnrollRequestMessage = PreEnrollRequestMessage("emmid:a68a3ba0744d2553819672eba454d438","Not Available",2,"emmid:a68a3ba0744d2553819672eba454d438.","Not Available",
                    Random = Random)
                val preEnrollModel = PreEnrollModel(preEnrollRequestMessage,0,0)
                val response = apiInterface.preEnrollAPICalling(preEnrollModel)
                if (response.isSuccessful()) {
                    //your code for handaling success response
                    Toast.makeText(
                        this@MainActivity,
                        response.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        response.errorBody().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }catch (Ex:Exception){
                Log.e("Error",Ex.localizedMessage)
            }
        }

    }

    private fun enrollRetrofitCall() {
        var retrofit = RetrofitClient.getInstance()
        var apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                var PinHash: ArrayList<Int> = arrayListOf(216,10,53,82,141,81,153,106,126)
                var Random: ArrayList<Int> = arrayListOf(74,181,17,120,197,61,185,182,123,139,11,98,14,252,150)
                val enrolleMessage = EnrolleMessage(2,"54e312a7-5f34-486f-a2f1-dfb214b7ae92",PinHash,
                Random = Random)
                val enrolleModel = EnrolleModel(enrolleMessage,0,0)
                val response = apiInterface.enrollAPICalling(enrolleModel)
                if (response.isSuccessful()) {
                    //your code for handaling success response
                    Toast.makeText(
                        this@MainActivity,
                        response.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        response.errorBody().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }catch (Ex:Exception){
                Log.e("Error",Ex.localizedMessage)
            }
        }

    }

    private fun certRetrofitCall() {
        var retrofit = RetrofitClient.getInstance()
        var apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                val updateDeviceInfoMessage = GetCertRequestMessage(1)
                val getCertModel = GetCertModel(updateDeviceInfoMessage,0,0)
                val response = apiInterface.getCertAPICalling(getCertModel)
                if (response.isSuccessful()) {
                    //your code for handaling success response
                    Toast.makeText(
                        this@MainActivity,
                        response.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        response.errorBody().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }catch (Ex:Exception){
                Log.e("Error",Ex.localizedMessage)
            }
        }

    }

    private fun UpdateDeviceInfoXmlRetrofitCall() {
        var retrofit = RetrofitClient.getInstance()
        var apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                var TokenList: ArrayList<Int> = arrayListOf(101,121,74,104,98,71,99,105,79,105,74,83,85,122,85,120,77,105,73,115,73,110,82,53,99,67,73,54,73,107,112,88,86,67,74,57,46,101,121,74,117,89,87,49,108,97,87,81,105,79,105,73,49,90,109,90,106,90,87,85,48,77,105,48,50,90,68,85,50,76,84,82,108,78,71,73,116,89,84,90,106,89,83,49,108,78,109,70,106,89,84,81,53,90,109,85,119,90,84,81,105,76,67,74,117,89,109,89,105,79,106,69,50,79,68,65,119,77,106,103,51,78,122,103,115,73,109,86,52,99,67,73,54,77,84,89,52,77,68,69,120,78,84,69,51,79,67,119,105,97,87,70,48,73,106,111,120,78,106,103,119,77,68,73,52,78,122,99,52,102,81,46,111,105,75,53,115,90,85,82,118,85,85,87,72,74,109,53,119,81,106,108,100,72,111,104,89,116,49,121,77,83,97,97,81,100,56,115,83,74,110,109,102,87,77,80,99,122,76,116,115,101,103,84,53,69,68,77,122,80,53,95,107,73,102,66,88,55,67,104,73,102,121,102,83,115,66,72,117,104,81,115,112,118,70,104,95,71,118,85,82,89,73,80,112,85,116,69,83,118,120,83,102,88,119,99,53,113,48,56,122,104,65,117,111,80,116,121,103,83,112,54,56,71,51,81,109,106,109,122,111,101,101,75,120,89,82,69,48,88,75,49,70,79,79,100,67,120,74,117,52,95,117,107,48,120,76,118,51,98,54,68,54,84,114,73,76,66,103,72,101,115,45,118,55,74,87,98,54,111,72,88,106,113,119,79,72,101,78,68,72,112,86,121,74,109,84,121,122,97,114,74,114,113,113,81,107,74,82,71,106,102,101,57,100,82,84,69,113,81,117,116,77,54,73,80,122,50,73,65,86,69,69,75,120,80,122,120,89,110,98,73,56,99,90,104,80,65,66,78,106,117,73,55,79,121,102,53,48,55,73,72,82,67,116,67,95,113,69,48,114,82,109,103,110,73,88,69,80,65,65,83,106,101,107,88,98,67,70,100,45,109,105,115,103,50,85,118,95,45,89,67,87,103,55,71,66,70,112,50,75,102,82,79,80,97,72,104,57,114,120,65,50,50,52,84,71,101,95,72,68,106,111,72,66,89,78,82,67,68,54,70,53,119)
                val updateDeviceInfoMessage = UpdateDeviceInfoMessage("\\u003cdevice-info version\\u003d\\\"1.0\\",TokenList)
                val sessionHanldeModel = UpdateDeviceInfoHanldeModel(updateDeviceInfoMessage)
                val response = apiInterface.updateDeviceInfoXmlAPICalling(sessionHanldeModel)
                if (response.isSuccessful()) {
                    //your code for handaling success response
                    Toast.makeText(
                        this@MainActivity,
                        response.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        response.errorBody().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }catch (Ex:Exception){
                Log.e("Error",Ex.localizedMessage)
            }
        }

    }

    private fun sessionTokencall() {
        val url = "https://reqres.in/api/management/SessionToken"
        val mRequestBody: String =
            "{\n" +
                    "\"Message\":{\n" +
                    "\"CryptoSuite\":0,\n" +
                    "\"Uuid\":\"String content\"\n" +
                    "},\n" +
                    "\"Status\":2147483647,\n" +
                    "\"StatusCode\":2147483647\n" +
                    "}"
        val stringRequest: StringRequest = object : StringRequest(
            Method.POST, url,
            Response.Listener { response ->
                moveToNextScreen(
                    mRequestBody,
                    response,
                    "SessionToken "
                )
            },
            Response.ErrorListener { error -> Log.e("LOG_VOLLEY", error.toString()) }) {
            override fun getBodyContentType(): String {
                return "application/json; charset=utf-8"
            }

            override fun getBody(): ByteArray {
                return mRequestBody.toByteArray(Charset.defaultCharset())
            }
        }
        requestQueue?.add(stringRequest)


    }

    private fun deviceInfoCall() {
        val url = "https://reqres.in/api/management/UpdateDeviceInfoXml"
        val mRequestBody: String =
           "{\n" +
                   "\"Message\":{\n" +
                   "\"DeviceInfo\":{\n" +
                   "},\n" +
                   "\"Token\":[81,\n" +
                   "109,\n" +
                   "70,\n" +
                   "122,\n" +
                   "90,\n" +
                   "83,\n" +
                   "65,\n" +
                   "50,\n" +
                   "78,\n" +
                   "67,\n" +
                   "66,\n" +
                   "84,\n" +
                   "100,\n" +
                   "72,\n" +
                   "74,\n" +
                   "108,\n" +
                   "89,\n" +
                   "87,\n" +
                   "48,\n" +
                   "61]\n" +
                   "},\n" +
                   "\"Status\":2147483647,\n" +
                   "\"StatusCode\":2147483647\n" +
                   "}\n"
        val stringRequest: StringRequest = object : StringRequest(
            Method.POST, url,
            Response.Listener { response ->
                moveToNextScreen(
                    mRequestBody,
                    response,
                    "UpdateDeviceInfo "
                )
            },
            Response.ErrorListener { error -> Log.e("LOG_VOLLEY", error.toString()) }) {
            override fun getBodyContentType(): String {
                return "application/json; charset=utf-8"
            }

            override fun getBody(): ByteArray {
                return mRequestBody.toByteArray(Charset.defaultCharset())
            }
        }
        requestQueue?.add(stringRequest)


    }

    private fun preEnrollCall() {
        val url = "https://reqres.in/api/preenrollment/PreEnroll"
        val mRequestBody: String =
           "{\n" +
                   "\"Message\":{\n" +
                   "\"AlternativeIdentifiers\":\"String content\",\n" +
                   "\"Country\":\"String content\",\n" +
                   "\"CryptoSuite\":0,\n" +
                   "\"DeviceIdentifier\":\"String content\",\n" +
                   "\"MDN\":\"String content\",\n" +
                   "\"PKOI\":255,\n" +
                   "\"PKOID\":255,\n" +
                   "\"Random\":[81,\n" +
                   "109,\n" +
                   "70,\n" +
                   "122,\n" +
                   "90,\n" +
                   "83,\n" +
                   "65,\n" +
                   "50,\n" +
                   "78,\n" +
                   "67,\n" +
                   "66,\n" +
                   "84,\n" +
                   "100,\n" +
                   "72,\n" +
                   "74,\n" +
                   "108,\n" +
                   "89,\n" +
                   "87,\n" +
                   "48,\n" +
                   "61]\n" +
                   "},\n" +
                   "\"Status\":2147483647,\n" +
                   "\"StatusCode\":2147483647\n" +
                   "}"
        val stringRequest: StringRequest = object : StringRequest(
            Method.POST, url,
            Response.Listener { response ->
                moveToNextScreen(
                    mRequestBody,
                    response,
                    "Pre - Enrollment"
                )
            },
            Response.ErrorListener { error -> Log.e("LOG_VOLLEY", error.toString()) }) {
            override fun getBodyContentType(): String {
                return "application/json; charset=utf-8"
            }

            override fun getBody(): ByteArray {
                return mRequestBody.toByteArray(Charset.defaultCharset())
            }
        }
        requestQueue?.add(stringRequest)
    }

    private fun enrollCall() {
        val url = "https://reqres.in/api/management/enrollment/Enroll"
        val mRequestBody: String =
            "{\n" +
                    "\"Message\":{\n" +
                    "\"CryptoSuite\":0,\n" +
                    "\"Id\":\"String content\",\n" +
                    "\"PinHash\":[81,\n" +
                    "109,\n" +
                    "70,\n" +
                    "122,\n" +
                    "90,\n" +
                    "83,\n" +
                    "65,\n" +
                    "50,\n" +
                    "78,\n" +
                    "67,\n" +
                    "66,\n" +
                    "84,\n" +
                    "100,\n" +
                    "72,\n" +
                    "74,\n" +
                    "108,\n" +
                    "89,\n" +
                    "87,\n" +
                    "48,\n" +
                    "61],\n" +
                    "\"Random\":[81,\n" +
                    "109,\n" +
                    "70,\n" +
                    "122,\n" +
                    "90,\n" +
                    "83,\n" +
                    "65,\n" +
                    "50,\n" +
                    "78,\n" +
                    "67,\n" +
                    "66,\n" +
                    "84,\n" +
                    "100,\n" +
                    "72,\n" +
                    "74,\n" +
                    "108,\n" +
                    "89,\n" +
                    "87,\n" +
                    "48,\n" +
                    "61]\n" +
                    "},\n" +
                    "\"Status\":2147483647,\n" +
                    "\"StatusCode\":2147483647\n" +
                    "}\n"
        val stringRequest: StringRequest = object : StringRequest(
            Method.POST, url,
            Response.Listener { response ->
                moveToNextScreen(
                    mRequestBody,
                    response,
                    "Enrollment"
                )
            },
            Response.ErrorListener { error -> Log.e("LOG_VOLLEY", error.toString()) }) {
            override fun getBodyContentType(): String {
                return "application/json; charset=utf-8"
            }

            override fun getBody(): ByteArray {
                return mRequestBody.toByteArray(Charset.defaultCharset())
            }
        }
        requestQueue?.add(stringRequest)

    }

    private fun certCall() {
        val url = "https://reqres.in/api/pki/GetCert/"
        val mRequestBody: String =
            "{\n" +
                    "    \"Message\":{\n" +
                    "        \"Format\":0\n" +
                    "    },\n" +
                    "    \"Status\":2147483647,\n" +
                    "    \"StatusCode\":2147483647\n" +
                    "}"

        val stringRequest: StringRequest = object : StringRequest(
            Method.POST, url,
            Response.Listener { response ->
                moveToNextScreen(
                    mRequestBody,
                    response,
                    "Get Certificate Request"
                )
            },
            Response.ErrorListener { error -> Log.e("LOG_VOLLEY", error.toString()) }) {
            override fun getBodyContentType(): String {
                return "application/json; charset=utf-8"
            }

            override fun getBody(): ByteArray {
                return mRequestBody.toByteArray(Charset.defaultCharset())
            }
        }
        requestQueue?.add(stringRequest)
    }

    private fun moveToNextScreen(mRequestBody: String, response: String, title: String) {
        startActivity(Intent(this@MainActivity, ResponseActivity::class.java).apply {
            // you can add values(if any) to pass to the next class or avoid using `.apply`
            putExtra("mRequestBody", mRequestBody)
            putExtra("response", response)
            putExtra("title", title)
        })
    }

    private fun jsonParse() {
        val url = "https://reqres.in/api/users"
        val request = JsonObjectRequest(Request.Method.GET, url, null, { response ->
            try {
                val jsonArray = response.getJSONArray("data")
                for (i in 0 until 4
                ) {
                    val employee = jsonArray.getJSONObject(i)
                    val firstName = employee.getString("first_name")
                    val last_name = employee.getString("last_name")
                    val avatar = employee.getString("avatar")
                    val email = employee.getString("email")
                    val id = employee.getInt("id")
                    userList.add(UserModel(id, email, firstName, last_name, avatar))
                }
                setRecyclerView()
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }, { error ->
            error.printStackTrace()
        })
        requestQueue?.add(request)
    }

    private fun setRecyclerView() {
        val recyclerView: RecyclerView = findViewById(R.id.list)
        customAdapter = CustomAdapter(userList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
    }

    fun sessionHandleRetrofitCall() {
        var retrofit = RetrofitClient.getInstance()
        var apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                var TokenList: ArrayList<Int> = arrayListOf(101,121,74,104,98,71,99,105,79,105,74,83,85,122,85,120,77,105,73,115,73,110,82,53,99,67,73,54,73,107,112,88,86,67,74,57,46,101,121,74,117,89,87,49,108,97,87,81,105,79,105,73,49,90,109,90,106,90,87,85,48,77,105,48,50,90,68,85,50,76,84,82,108,78,71,73,116,89,84,90,106,89,83,49,108,78,109,70,106,89,84,81,53,90,109,85,119,90,84,81,105,76,67,74,117,89,109,89,105,79,106,69,50,79,68,65,119,77,106,103,51,78,122,103,115,73,109,86,52,99,67,73,54,77,84,89,52,77,68,69,120,78,84,69,51,79,67,119,105,97,87,70,48,73,106,111,120,78,106,103,119,77,68,73,52,78,122,99,52,102,81,46,111,105,75,53,115,90,85,82,118,85,85,87,72,74,109,53,119,81,106,108,100,72,111,104,89,116,49,121,77,83,97,97,81,100,56,115,83,74,110,109,102,87,77,80,99,122,76,116,115,101,103,84,53,69,68,77,122,80,53,95,107,73,102,66,88,55,67,104,73,102,121,102,83,115,66,72,117,104,81,115,112,118,70,104,95,71,118,85,82,89,73,80,112,85,116,69,83,118,120,83,102,88,119,99,53,113,48,56,122,104,65,117,111,80,116,121,103,83,112,54,56,71,51,81,109,106,109,122,111,101,101,75,120,89,82,69,48,88,75,49,70,79,79,100,67,120,74,117,52,95,117,107,48,120,76,118,51,98,54,68,54,84,114,73,76,66,103,72,101,115,45,118,55,74,87,98,54,111,72,88,106,113,119,79,72,101,78,68,72,112,86,121,74,109,84,121,122,97,114,74,114,113,113,81,107,74,82,71,106,102,101,57,100,82,84,69,113,81,117,116,77,54,73,80,122,50,73,65,86,69,69,75,120,80,122,120,89,110,98,73,56,99,90,104,80,65,66,78,106,117,73,55,79,121,102,53,48,55,73,72,82,67,116,67,95,113,69,48,114,82,109,103,110,73,88,69,80,65,65,83,106,101,107,88,98,67,70,100,45,109,105,115,103,50,85,118,95,45,89,67,87,103,55,71,66,70,112,50,75,102,82,79,80,97,72,104,57,114,120,65,50,50,52,84,71,101,95,72,68,106,111,72,66,89,78,82,67,68,54,70,53,119)
                val tokenArray = Message(TokenList)
                val sessionHanldeModel = SessionHanldeModel(tokenArray, 0,0)
                val response = apiInterface.sessionHandleAPICalling(sessionHanldeModel)
                if (response.isSuccessful()) {
                    //your code for handaling success response
                    Toast.makeText(
                        this@MainActivity,
                        response.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        response.errorBody().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }catch (Ex:Exception){
                Log.e("Error",Ex.localizedMessage)
            }
        }

    }

}