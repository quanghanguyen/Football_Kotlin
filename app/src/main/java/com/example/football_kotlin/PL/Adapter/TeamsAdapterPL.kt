package com.example.football_kotlin.PL.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.football_kotlin.PL.ModelPL.Team
import com.example.football_kotlin.R
import de.hdodenhof.circleimageview.CircleImageView

class TeamsAdapterPL(val context : Context, val teamsList : List<Team>) : RecyclerView.Adapter<TeamsAdapterPL.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var civTeams : CircleImageView
        var tvTeams : TextView

        init {
            civTeams = itemView.findViewById<View>(R.id.civTeams) as CircleImageView
            tvTeams = itemView.findViewById<View>(R.id.tvTeams) as TextView
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View
        v = LayoutInflater.from(context).inflate(R.layout.list_pl_teams_items, parent, false)
        val vHolder : ViewHolder = ViewHolder(v)
        return vHolder

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTeams.text = teamsList[position].name

    // glide
        Glide.with(context)
            .load(teamsList[position].crestUrl)
            .into(holder.civTeams)


    }

    override fun getItemCount(): Int {
        return teamsList.size
    }

}