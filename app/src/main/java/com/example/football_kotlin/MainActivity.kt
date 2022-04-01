package com.example.football_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.football_kotlin.PL.HomePL
import com.example.football_kotlin.PL.InterfacePL.MainAPI
import com.example.football_kotlin.PL.InterfacePL.PLTeams
import com.example.football_kotlin.PL.ModelPL.ModelPLHome
import com.example.football_kotlin.PL.ModelPL.Team
import com.example.football_kotlin.PL.ModelPL.TeamsDataPL
import de.hdodenhof.circleimageview.CircleImageView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.football-data.org/v2/competitions/2021/"

class MainActivity : AppCompatActivity() {

    //PL
    private var tvPLName: TextView? = null
    private var tvstartDate: TextView? = null
    private var tvendDate: TextView? = null
    private var tvmatchDay: TextView? = null
    private var cvPL: CardView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //PL
        tvPLName = findViewById<View>(R.id.tvNamePL) as TextView
        tvstartDate = findViewById<View>(R.id.tvstartDate) as TextView
        tvendDate = findViewById<View>(R.id.tvendDate) as TextView
        tvmatchDay = findViewById<View>(R.id.tvmatchDay) as TextView
        cvPL = findViewById<View>(R.id.cvPL) as CardView

        // Call API
        getPLDataHome();

        //onClick
        clickPL();

//        val button:Button = findViewById(R.id.btnClickme)
//        button.setOnClickListener{
//            val intent = Intent(this@MainActivity, DemoActivity::class.java)
//            startActivity(intent)
//        }
    }

    private fun clickPL() {
        val cvPL:CardView = findViewById(R.id.cvPL)
        cvPL.setOnClickListener{
            val intent = Intent(this@MainActivity, HomePL::class.java)
            startActivity(intent)
        }
    }

    private fun getPLDataHome() {

        val plMain = RetrofitClient.retrofitInstance?.create(MainAPI::class.java)
        val call = plMain?.allMainData

        call?.enqueue(object : Callback<ModelPLHome?> {
            override fun onResponse(call: Call<ModelPLHome?>, response: Response<ModelPLHome?>) {
                Log.e(TAG, "onResponse : " + response.body()!!.name)
                Log.e(TAG, "onResponse : " + response.body()!!.emblemUrl)

                val PLMain = response.body()
                tvPLName!!.text = PLMain!!.name
                tvstartDate!!.text = PLMain!!.currentSeason.startDate
                tvendDate!!.text = PLMain!!.currentSeason.endDate
                tvmatchDay!!.text = PLMain!!.currentSeason.currentMatchday.toString()



            }

            override fun onFailure(call: Call<ModelPLHome?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })




        //------------------------------------------------------------------------------------------

//        val retrofitBuilder = Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl(BASE_URL)
//            .build()
//            .create(MainAPI::class.java)
//
//
//        val retrofitData = retrofitBuilder.getPLDataHome()
//
//        retrofitData.enqueue(object : Callback<ModelPLHome?> {
//            override fun onResponse(call: Call<ModelPLHome?>, response: Response<ModelPLHome?>) {
//
//                Log.e(TAG, "onResponse: code : " + response.body()!!.name)
//                Log.e(TAG, "onResponse: code : " + response.body()!!.currentSeason.startDate)
//                Log.e(TAG, "onResponse: code : " + response.body()!!.currentSeason.endDate)
//                Log.e(TAG, "onResponse: code : " + response.body()!!.currentSeason.currentMatchday)
//
////                val PLData = response.body()!!
////                tvPLName!!.text = PLData!!.name
////                tvstartDate!!.text = PLData!!.currentSeason.startDate
////                tvendDate!!.text = PLData!!.currentSeason.endDate
////                tvmatchDay!!.text = PLData!!.currentSeason.currentMatchday.toString()
//
//            }
//
//            override fun onFailure(call: Call<ModelPLHome?>, t: Throwable) {
//
//            }
//        })
    }

    companion object {
        private const val TAG = "MainActivity"
    }

}