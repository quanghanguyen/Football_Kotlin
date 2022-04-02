package com.example.football_kotlin.PL.FragmentPL

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.football_kotlin.PL.Adapter.ChartAdapterPL
import com.example.football_kotlin.PL.InterfacePL.PLChart
import com.example.football_kotlin.PL.ModelPL.Standings
import com.example.football_kotlin.PL.ModelPL.Table
import com.example.football_kotlin.R
import com.example.football_kotlin.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class ChartPLFragment : Fragment() {

    var adapter : ChartAdapterPL? = null
    var v : View? = null
    var recyclerView : RecyclerView? = null
    var lstChart : MutableList<Table>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lstChart = ArrayList()

        callChartPLData();


    }

    private fun callChartPLData() {

        val plChart = RetrofitClient.retrofitInstance?.create(PLChart::class.java)
        val callChart = plChart?.allChartData

        callChart?.enqueue(object : Callback<Standings?> {
            override fun onResponse(call: Call<Standings?>, response: Response<Standings?>) {
                val standings = response.body()
                if (standings!!. message != null) {
                        requireActivity().runOnUiThread{
                            Toast.makeText(
                                requireContext(),
                                standings.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                } else {
                    val chartInfo = response.body()!!.standings
                    Log.e(TAG, "onResponse size: " + chartInfo.size)
                    for (i in chartInfo.indices) {
                        Log.e("chartInfo", chartInfo[i].toString())
                    }
                    lstChart!!.addAll(chartInfo[0].table)
                    adapter!!.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<Standings?>, t: Throwable) {
                Log.e("onFailure", "onFailure")
                Log.e("t", t.toString())
            }
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_chart_p_l, container, false)
        recyclerView = v.findViewById<View>(R.id.rcvChartPL) as RecyclerView
        adapter = ChartAdapterPL(requireContext(), lstChart!!)
        recyclerView!!.layoutManager = LinearLayoutManager(activity)
        recyclerView!!.adapter = adapter
        return v
    }

    companion object {
        private const val TAG = "ChartFragment"
    }

}