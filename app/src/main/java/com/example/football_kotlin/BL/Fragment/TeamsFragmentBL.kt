package com.example.football_kotlin.BL.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.football_kotlin.BL.AdapterBL.BLTeamsAdapter
import com.example.football_kotlin.BL.InterfaceBL.TeamsBL
import com.example.football_kotlin.BL.ModelBL.BLTeamsModelX
import com.example.football_kotlin.BL.ModelBL.TeamX
import com.example.football_kotlin.R
import com.example.football_kotlin.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TeamsFragmentBL : Fragment() {

    var recyclerView : RecyclerView? = null
    var adapterBL : BLTeamsAdapter? = null
    var lstTeamsBL : MutableList<TeamX>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lstTeamsBL = ArrayList<TeamX>()
        callBLTeamsData();

    }

    private fun callBLTeamsData() {
        val BLTeams = RetrofitClient.retrofitInstance?.create(TeamsBL::class.java)
        val callBLTeams = BLTeams?.getBLTeamsData

        callBLTeams?.enqueue(object : Callback<BLTeamsModelX?> {
            override fun onResponse(
                call: Call<BLTeamsModelX?>,
                response: Response<BLTeamsModelX?>
            ) {
                val BLTeamsData = response.body()!!.teams
                lstTeamsBL!!.addAll(BLTeamsData)
                adapterBL!!.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<BLTeamsModelX?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_teams_b_l, container, false)
        recyclerView = v.findViewById<View>(R.id.rcvTeamsBL) as RecyclerView
        adapterBL = BLTeamsAdapter(requireContext(), lstTeamsBL!!)
        recyclerView!!.layoutManager = LinearLayoutManager(activity)
        recyclerView!!.adapter = adapterBL
        return v

    }
}