package com.example.football_kotlin.PL.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.football_kotlin.PL.ModelPL.Table
import com.example.football_kotlin.R
import de.hdodenhof.circleimageview.CircleImageView

class ChartAdapterPL(val context: Context, val lstChart: List<Table>) : RecyclerView.Adapter<ChartAdapterPL.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvPosition: TextView
        val tvNameTeam: TextView
        val civTeamIcon: CircleImageView
        val tvW: TextView
        val tvL: TextView
        val tvD: TextView
        val tvP: TextView

        init {
            tvPosition = itemView.findViewById<View>(R.id.tvPosition) as TextView
            tvNameTeam = itemView.findViewById<View>(R.id.tvNameTeam) as TextView
            civTeamIcon = itemView.findViewById<View>(R.id.civTeamIcon) as CircleImageView
            tvW = itemView.findViewById<View>(R.id.tvW) as TextView
            tvL = itemView.findViewById<View>(R.id.tvL) as TextView
            tvD = itemView.findViewById<View>(R.id.tvD) as TextView
            tvP = itemView.findViewById<View>(R.id.tvP) as TextView
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v : View
        v = LayoutInflater.from(context).inflate(R.layout.list_chart_pl, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvPosition.text = lstChart[position].position.toString()
        holder.tvNameTeam.text = lstChart[position].team.name
        holder.tvW.text = lstChart[position].won.toString()
        holder.tvL.text = lstChart[position].lost.toString()
        holder.tvD.text = lstChart[position].draw.toString()
        holder.tvP.text = lstChart[position].points.toString()
        Glide.with(context)
            .load(lstChart[position].team.crestUrl)
            .into(holder.civTeamIcon)

    }

    override fun getItemCount(): Int {
        return lstChart.size
    }


}