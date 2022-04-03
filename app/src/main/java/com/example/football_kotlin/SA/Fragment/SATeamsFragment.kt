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
import com.example.football_kotlin.SA.AdapterSA.TeamsAdapter
import com.example.football_kotlin.SA.InterfaceSA.SATeamsAPI
import com.example.football_kotlin.SA.ModelSA.SATeamsModel
import com.example.football_kotlin.SA.ModelSA.Team
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SATeamsFragment : Fragment() {

    var recyclerViewSA : RecyclerView? = null
    var adapterSA : TeamsAdapter? = null
    var lstSATeams : MutableList<Team>? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lstSATeams = ArrayList<Team>()
        callSATeamsData();

    }

    private fun callSATeamsData() {
        val saTeamsModel = RetrofitClient.retrofitInstance?.create(SATeamsAPI::class.java)
        val callSATeamsModel = saTeamsModel?.getSATeamsData

        callSATeamsModel?.enqueue(object : Callback<SATeamsModel?> {
            override fun onResponse(call: Call<SATeamsModel?>, response: Response<SATeamsModel?>) {
                val saTeams = response.body()!!.teams

                lstSATeams!!.addAll(saTeams)
                adapterSA!!.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<SATeamsModel?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_s_a_teams, container, false)
        recyclerViewSA = v.findViewById(R.id.rcvTeamsSA)
        adapterSA = TeamsAdapter(requireContext(), lstSATeams!!)
        recyclerViewSA!!.layoutManager = LinearLayoutManager(activity)
        recyclerViewSA!!.adapter = adapterSA
        return v
    }

}