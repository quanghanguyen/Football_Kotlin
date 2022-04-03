package com.example.football_kotlin.SA.AdapterSA

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.football_kotlin.R
import com.example.football_kotlin.SA.ModelSA.Team
import de.hdodenhof.circleimageview.CircleImageView

class TeamsAdapter(val context: Context, val lstTeamsSA : List<Team>) : RecyclerView.Adapter<TeamsAdapter.MyViewHolder>() {
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        var tvSATeamsName : TextView? = null
        var civSATeams : CircleImageView? = null

        init {
            tvSATeamsName = itemView.findViewById(R.id.tvTeamsSA)
            civSATeams = itemView.findViewById<View>(R.id.civTeamsSA) as CircleImageView
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v : View
        v = LayoutInflater.from(context).inflate(R.layout.list_teams_sa, parent, false)
        val vHolder : MyViewHolder = MyViewHolder(v)
        return vHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvSATeamsName!!.text = lstTeamsSA[position].name

        holder.civSATeams?.let {
            Glide.with(context)
                .load(lstTeamsSA[position].crestUrl)
                .into(it)
        }
    }

    override fun getItemCount(): Int {
        return lstTeamsSA.size
    }
}