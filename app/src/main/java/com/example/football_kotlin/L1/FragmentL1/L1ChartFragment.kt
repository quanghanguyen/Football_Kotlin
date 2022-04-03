package com.example.football_kotlin.L1.FragmentL1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.football_kotlin.L1.Adapter.L1ChartAdapter
import com.example.football_kotlin.L1.InterfaceL1.L1Chart
import com.example.football_kotlin.L1.ModelL1.Standings
import com.example.football_kotlin.L1.ModelL1.Table
import com.example.football_kotlin.R
import com.example.football_kotlin.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class L1ChartFragment : Fragment() {

    var adapterL1 : L1ChartAdapter? = null
    var v : View? = null
    var recyclerViewL1 : RecyclerView? = null
    var lstChartL1 : MutableList<Table>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lstChartL1 = ArrayList()
        callL1ChartData();

    }

    private fun callL1ChartData() {
        val plChartL1 = RetrofitClient.retrofitInstance?.create(L1Chart::class.java)
        val callL1Chart = plChartL1?.allL1ChartData

        callL1Chart?.enqueue(object : Callback<Standings?> {
            override fun onResponse(call: Call<Standings?>, response: Response<Standings?>) {
                val standingsL1 = response.body()

                if (standingsL1!!. message != null) {
                    requireActivity().runOnUiThread{
                        Toast.makeText(
                            requireContext(),
                            standingsL1.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    val ChartL1Info = response.body()!!.standings

                    lstChartL1!!.addAll(ChartL1Info[0].table)
                    adapterL1!!.notifyDataSetChanged()

                }
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
        val v = inflater.inflate(R.layout.fragment_l1_chart, container, false)
        recyclerViewL1 = v.findViewById<View>(R.id.rcvChartL1) as RecyclerView
        adapterL1 = L1ChartAdapter(requireContext(), lstChartL1!!)
        recyclerViewL1!!.layoutManager = LinearLayoutManager(activity)
        recyclerViewL1!!.adapter = adapterL1
        return v
    }

}