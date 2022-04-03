package com.example.football_kotlin.BL.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.football_kotlin.BL.AdapterBL.BLChartAdapter
import com.example.football_kotlin.BL.InterfaceBL.ChartBL
import com.example.football_kotlin.BL.ModelBL.BLChartModel
import com.example.football_kotlin.BL.ModelBL.Table
import com.example.football_kotlin.R
import com.example.football_kotlin.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create


class ChartFragmentBL : Fragment() {

    var recyclerViewChart : RecyclerView? = null
    var v : View? = null
    var adapterBL : BLChartAdapter? = null
    var lstChartBL : MutableList<Table>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lstChartBL = ArrayList()

        callBLChartData();

    }

    private fun callBLChartData() {
        val blChartModel = RetrofitClient.retrofitInstance?.create(ChartBL::class.java)
        val callBLChartData = blChartModel?.getBLChartData

        callBLChartData?.enqueue(object : Callback<BLChartModel?> {
            override fun onResponse(call: Call<BLChartModel?>, response: Response<BLChartModel?>) {
                val chartData = response.body()!!.standings
                lstChartBL!!.addAll(chartData[0].table)
                adapterBL!!.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<BLChartModel?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_chart_b_l, container, false)
        recyclerViewChart = v.findViewById(R.id.rcvChartBL)
        adapterBL = BLChartAdapter(requireContext(), lstChartBL!!)
        recyclerViewChart!!.layoutManager = LinearLayoutManager(activity)
        recyclerViewChart!!.adapter = adapterBL
        return v
    }

}