package com.example.football_kotlin.SA.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.football_kotlin.R
import com.example.football_kotlin.RetrofitClient
import com.example.football_kotlin.SA.AdapterSA.ChartAdapter
import com.example.football_kotlin.SA.InterfaceSA.SAChartAPI
import com.example.football_kotlin.SA.ModelSA.Standings
import com.example.football_kotlin.SA.ModelSA.Table
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SAChartFragment : Fragment() {

    var recyclerViewSA : RecyclerView? = null
    var v : View? = null
    var adapterSA : ChartAdapter? = null
    var lstChartSA : MutableList<Table>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lstChartSA = ArrayList()

        callSAChartData();

    }

    private fun callSAChartData() {
        val SAChartData = RetrofitClient.retrofitInstance?.create(SAChartAPI::class.java)
        val callSAChartData = SAChartData?.getSAChartData

        callSAChartData?.enqueue(object : Callback<Standings?> {
            override fun onResponse(call: Call<Standings?>, response: Response<Standings?>) {
                val SAChartData = response.body()!!.standings

                lstChartSA!!.addAll(SAChartData[0].table)
                adapterSA!!.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<Standings?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val v = inflater.inflate(R.layout.fragment_s_a_chart, container, false)
        recyclerViewSA = v.findViewById(R.id.rcvChartSA)
        adapterSA = ChartAdapter(requireContext(), lstChartSA!!)
        recyclerViewSA!!.layoutManager = LinearLayoutManager(activity)
        recyclerViewSA!!.adapter = adapterSA
        return v

    }

}