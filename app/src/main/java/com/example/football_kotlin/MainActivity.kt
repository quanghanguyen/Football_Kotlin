package com.example.football_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.football_kotlin.BL.HomeBL
import com.example.football_kotlin.BL.ModelBL.ModelMain
import com.example.football_kotlin.L1.HomeL1
import com.example.football_kotlin.L1.InterfaceL1.MainAPIL1
import com.example.football_kotlin.L1.ModelL1.ModelL1Main
import com.example.football_kotlin.PL.HomePL
import com.example.football_kotlin.PL.InterfacePL.MainAPI
import com.example.football_kotlin.PL.ModelPL.ModelPLHome
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val BASE_URL = "https://api.football-data.org/v2/competitions/2021/"

class MainActivity : AppCompatActivity() {

    //PL
    private var tvPLName: TextView? = null
    private var tvstartDate: TextView? = null
    private var tvendDate: TextView? = null
    private var tvmatchDay: TextView? = null
    private var cvPL: CardView? = null

    //L1
    var tvL1Name : TextView? = null
    var tvL1StartDate : TextView? = null
    var tvL1EndDate : TextView? = null
    var tvL1MatchDay : TextView? = null
    var cvL1 : CardView? = null

    //BL
    var tvBLName : TextView? = null
    var tvBLStartDate : TextView? = null
    var tvBLEndDate : TextView? = null
    var tvBLMatchDay : TextView? = null
    var cvBL : CardView? = null



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

        //L1
        tvL1Name = findViewById<View>(R.id.tvNameL1) as TextView
        tvL1StartDate = findViewById<View>(R.id.tvstartDate1) as TextView
        tvL1EndDate = findViewById<View>(R.id.tvendDate1) as TextView
        tvL1MatchDay = findViewById<View>(R.id.tvmatchDay1) as TextView
        cvL1 = findViewById<View>(R.id.cvL1) as CardView

        //BL
        tvBLName = findViewById<View>(R.id.tvNameBL) as TextView
        tvBLStartDate = findViewById<View>(R.id.tvstartDate2) as TextView
        tvBLEndDate = findViewById<View>(R.id.tvendDate2) as TextView
        tvBLMatchDay = findViewById<View>(R.id.tvmatchDay2) as TextView
        cvBL = findViewById<View>(R.id.cvBL) as CardView



        // Call API
        getPLDataHome();
        getL1DataHome();
        getBLDataHome();

        //onClick
        clickPL();
        clickL1();
        clickBL();

    }

    private fun getBLDataHome() {
        val blMain = RetrofitClient.retrofitInstance?.create(com.example.football_kotlin.BL.InterfaceBL.MainAPI::class.java)
        val callMainBL = blMain?.allMainDataBL

        callMainBL?.enqueue(object : Callback<ModelMain?> {
            override fun onResponse(call: Call<ModelMain?>, response: Response<ModelMain?>) {
                val BLMain = response.body()

                tvBLName!!.text = BLMain!!.name
                tvBLStartDate!!.text = BLMain!!.currentSeason.startDate
                tvBLEndDate!!.text = BLMain!!.currentSeason.endDate
                tvBLMatchDay!!.text = BLMain!!.currentSeason.currentMatchday.toString()
            }

            override fun onFailure(call: Call<ModelMain?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

//        callMainBL?.enqueue(object : Callback<ModelMain?> {
//            override fun onResponse(call: Call<ModelMain?>, response: Response<ModelMain?>) {
//                val BLMain = response.body()
//
//                tvBLName!!.text = BLMain!!.name
//                tvBLStartDate!!.text = BLMain!!.currentSeason.startDate
//                tvBLEndDate!!.text = BLMain!!.currentSeason.endDate
//                tvBLMatchDay!!.text = BLMain!!.currentSeason.currentMatchday.toString()
//
//            }
//
//            override fun onFailure(call: Call<ModelPLHome?>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//        })
    }

    private fun clickBL() {
        val cvBL:CardView = findViewById<View>(R.id.cvBL) as CardView
        cvBL.setOnClickListener {
            val intent = Intent(this@MainActivity, HomeBL::class.java)
            startActivity(intent)
        }
    }

    private fun getL1DataHome() {
        val l1Main = RetrofitClient.retrofitInstance?.create(MainAPIL1::class.java)
        val callL1 = l1Main?.allL1MainData

        callL1?.enqueue(object : Callback<ModelL1Main?> {
            override fun onResponse(call: Call<ModelL1Main?>, response: Response<ModelL1Main?>) {
                Log.e(TAG, "onResponse : " + response.body()!!.name)
                Log.e(TAG, "onResponse: "+ response.body()!!.emblemUrl)

                val L1Main = response.body()
                tvL1Name!!.text = L1Main!!.name
                tvL1StartDate!!.text = L1Main!!.currentSeason.startDate
                tvL1EndDate!!.text = L1Main!!.currentSeason.endDate
                tvL1StartDate!!.text = L1Main!!.currentSeason.currentMatchday.toString()

            }

            override fun onFailure(call: Call<ModelL1Main?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun clickL1() {
        val cvL1:CardView = findViewById(R.id.cvL1)
        cvL1.setOnClickListener {
            val intent = Intent(this@MainActivity, HomeL1::class.java)
            startActivity(intent)
        }
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