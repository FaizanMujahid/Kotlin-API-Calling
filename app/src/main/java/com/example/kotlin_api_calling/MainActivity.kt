package com.example.kotlin_api_calling

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.kotlin_api_calling.ResponseModels.UserModel
import org.json.JSONArray
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)

        requestQueue = Volley.newRequestQueue(this)
        jsonParse()
        btn1.setOnClickListener { certCall() }
        btn2.setOnClickListener { enrollCall() }
        btn3.setOnClickListener { preEnrollCall()}
        btn4.setOnClickListener { deviceInfoCall()}
        btn5.setOnClickListener { sessionTokencall()}
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

}