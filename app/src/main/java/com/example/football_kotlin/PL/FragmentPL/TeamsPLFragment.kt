 package com.example.football_kotlin.PL.FragmentPL

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.football_kotlin.MainActivity
import com.example.football_kotlin.PL.Adapter.TeamsAdapterPL
import com.example.football_kotlin.PL.InterfacePL.PLTeams
import com.example.football_kotlin.PL.ModelPL.Team
import com.example.football_kotlin.PL.ModelPL.TeamsDataPL
import com.example.football_kotlin.R
import com.example.football_kotlin.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

 const val BASE_URL_PL_TEAMS = "https://api.football-data.org/v2/competitions/2021/teams"

class TeamsPLFragment : Fragment() {

//    lateinit var teamsAdapterPL: TeamsAdapterPL
//    private var linearLayoutManager: LinearLayoutManager? = null
//    lateinit var recyclerView: RecyclerView
//    var lstTeam : MutableList<Team> = mutableListOf()

    //
    private var myrecyclerview: RecyclerView? = null
    private var lstTeams: MutableList<Team>? = null
    private var adapter: TeamsAdapterPL? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lstTeams = ArrayList<Team>()
        PLTeamsDataCall();

    }

    private fun PLTeamsDataCall() {

        val plTeams = RetrofitClient.retrofitInstance?.create(PLTeams::class.java)
        val callTeams = plTeams?.allTeamsData

        callTeams?.enqueue(object : Callback<TeamsDataPL?> {
            override fun onResponse(call: Call<TeamsDataPL?>, response: Response<TeamsDataPL?>) {
                Log.e(TAG, "onResponse : " + response.body()!!.count)
//                Log.e(TAG, "onResponse: " + response.body()!!

                val teamsData = response.body()!!.teams

                for (teamsData1 in teamsData ){
                    Log.e(TAG, "onResponse: " + teamsData1!!.name)
                    Log.e(TAG, "onResponse: " + teamsData1!!.crestUrl)
                }

                lstTeams!!.addAll(teamsData)
                adapter!!.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<TeamsDataPL?>, t: Throwable) {

            }
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

//        val v = inflater!!.inflate(R.layout.fragment_teams_p_l, container, false)
//        val recyclerView = v.findViewById<RecyclerView>(R.id.rcvTeamsPL) as RecyclerView
//        linearLayoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
//
//        recyclerView?.layoutManager = linearLayoutManager
//        recyclerView?.adapter = teamsAdapterPL
//        recyclerView?.setHasFixedSize(true);

        val v = inflater.inflate(R.layout.fragment_teams_p_l, container, false)

        myrecyclerview = v.findViewById<View>(R.id.rcvTeamsPL) as RecyclerView
        adapter = TeamsAdapterPL(context, lstTeams)
        myrecyclerview!!.layoutManager = LinearLayoutManager(activity)
        myrecyclerview!!.adapter = adapter
        return v
    }

    companion object {
        private const val TAG = "TeamsFragment"
    }

}