package com.ananananzhuo.composeapi.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.ananananzhuo.composeapi.R

class GenerateActivityResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generate_result)
        val tvParam = findViewById<TextView>(R.id.tv_data)
        tvParam.text = "compose传给Activity的数据:=${intent.getStringExtra("data")}"
        findViewById<Button>(R.id.btn_returnResult).setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("data","World")
            setResult(RESULT_OK,resultIntent)
            finish()
        }
    }
}