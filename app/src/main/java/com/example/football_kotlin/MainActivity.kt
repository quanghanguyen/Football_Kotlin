package com.example.football_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.football_kotlin.InterfacePL.MainAPI
import com.example.football_kotlin.ModelPL.ModelPLHome
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.football-data.org/v2/competitions/2021"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        getPLDataHome();

//        val button:Button = findViewById(R.id.btnClickme)
//        button.setOnClickListener{
//            val intent = Intent(this@MainActivity, DemoActivity::class.java)
//            startActivity(intent)
//        }
    }

    private fun getPLDataHome() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(MainAPI::class.java)


        val retrofitData = retrofitBuilder.getPLDataHome()

        retrofitData.enqueue(object : Callback<ModelPLHome?> {
            override fun onResponse(call: Call<ModelPLHome?>, response: Response<ModelPLHome?>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<ModelPLHome?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}