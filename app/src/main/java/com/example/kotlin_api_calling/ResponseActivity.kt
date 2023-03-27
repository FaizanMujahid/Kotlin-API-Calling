package com.example.kotlin_api_calling

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResponseActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_response)
        val  pagetitle = findViewById<TextView>(R.id.pagetitle) as TextView
        val  response = findViewById<TextView>(R.id.response) as TextView
        val  requestBody = findViewById<TextView>(R.id.requestBody) as TextView
        response.text = intent.getStringExtra("response").toString()
        requestBody.text = intent.getStringExtra("mRequestBody")
        pagetitle.text = intent.getStringExtra("title")
    }
}
