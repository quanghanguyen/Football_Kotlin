package com.example.football_kotlin.BL.AdapterBL

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.football_kotlin.BL.ModelBL.Table
import com.example.football_kotlin.BL.ModelBL.TeamX
import com.example.football_kotlin.R
import de.hdodenhof.circleimageview.CircleImageView
import java.util.zip.Inflater

class BLTeamsAdapter(val context: Context, val lstTeamsBL : List<TeamX>) : RecyclerView.Adapter<BLTeamsAdapter.MyViewHolder>() {
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)  {

        var tvBLTeamsName : TextView
        var civBLTeams : CircleImageView

        init {
            tvBLTeamsName = itemView.findViewById<View>(R.id.tvTeamsBL) as TextView
            civBLTeams = itemView.findViewById<View>(R.id.civTeamsBL) as CircleImageView
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v : View
        v = LayoutInflater.from(context).inflate(R.layout.list_teams_bl, parent, false)
        val vHolder : MyViewHolder = MyViewHolder(v)
        return vHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.tvBLTeamsName.text = lstTeamsBL[position].name
        Glide.with(context)
            .load(lstTeamsBL[position].crestUrl)
            .into(holder.civBLTeams)

    }

    override fun getItemCount(): Int {

        return lstTeamsBL.size

    }
}