package com.example.kotlin_api_calling

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException

class MainActivity : AppCompatActivity() {
    private var requestQueue: RequestQueue? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestQueue = Volley.newRequestQueue(this)
        jsonParse()

    }

    private fun jsonParse() {
        val url = "https://reqres.in/api/users"
        val request = JsonObjectRequest(Request.Method.GET, url, null, { response ->
            try {
                Toast.makeText(this,response.toString(),Toast.LENGTH_LONG).show()
//
//                val jsonArray = response.getJSONArray("data")
//                for (i in 0 until jsonArray.length()) {
//                    val employee = jsonArray.getJSONObject(i)
//                    val firstName = employee.getString("firstname")
//                    val age = employee.getInt("age")
//                    val mail = employee.getString("mail")
////                textView.append("$firstName, $age, $mail")
//                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }, { error ->
            error.printStackTrace()
            Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
        })
        requestQueue?.add(request)
    }
}