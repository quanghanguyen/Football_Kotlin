package com.example.football_kotlin.L1.FragmentL1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.football_kotlin.L1.Adapter.L1TeamsAdapter
import com.example.football_kotlin.L1.InterfaceL1.L1Teams
import com.example.football_kotlin.L1.ModelL1.Team
import com.example.football_kotlin.R
import com.example.football_kotlin.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class L1TeamsFragment : Fragment() {

    //
    var recyclerView : RecyclerView? = null
    var lstL1Teams : MutableList<Team>? = null
    var adapter : L1TeamsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lstL1Teams = ArrayList<Team>()
        callL1TeamsData();

    }

    private fun callL1TeamsData() {

        val l1Teams = RetrofitClient.retrofitInstance?.create(L1Teams::class.java)
        val callL1Teams = l1Teams?.allTeamsL1Data

        callL1Teams?.enqueue(object : Callback<com.example.football_kotlin.L1.ModelL1.L1Teams?> {
            override fun onResponse(
                call: Call<com.example.football_kotlin.L1.ModelL1.L1Teams?>,
                response: Response<com.example.football_kotlin.L1.ModelL1.L1Teams?>
            ) {
                val l1TeamsData = response.body()!!.teams
                lstL1Teams!!.addAll(l1TeamsData)
                adapter!!.notifyDataSetChanged()

            }

            override fun onFailure(
                call: Call<com.example.football_kotlin.L1.ModelL1.L1Teams?>,
                t: Throwable
            ) {
                TODO("Not yet implemented")
            }
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_l1_teams, container, false)
        recyclerView = v.findViewById<View>(R.id.rcvL1) as RecyclerView
        adapter = L1TeamsAdapter(requireContext(), lstL1Teams!!)
        recyclerView!!.layoutManager = LinearLayoutManager(activity)
        recyclerView!!.adapter = adapter

        return v


    }

}