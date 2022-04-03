package com.example.football_kotlin.BL.AdapterBL

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.football_kotlin.BL.ModelBL.Table
import com.example.football_kotlin.R
import de.hdodenhof.circleimageview.CircleImageView

class BLChartAdapter(val context: Context, val lstBlChart : List<Table>) : RecyclerView.Adapter<BLChartAdapter.MyViewHolder>() {
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val tvPositionBL: TextView
        val tvNameTeamBL: TextView
        val civTeamIconBL: CircleImageView
        val tvWBL: TextView
        val tvLBL: TextView
        val tvDBL: TextView
        val tvPBL: TextView

        init {
            tvPositionBL = itemView.findViewById<View>(R.id.tvPositionBL) as TextView
            tvNameTeamBL = itemView.findViewById<View>(R.id.tvNameTeamBL) as TextView
            civTeamIconBL = itemView.findViewById<View>(R.id.civTeamIconBL) as CircleImageView
            tvWBL = itemView.findViewById<View>(R.id.tvWBL) as TextView
            tvLBL = itemView.findViewById<View>(R.id.tvLBL) as TextView
            tvDBL = itemView.findViewById<View>(R.id.tvDBL) as TextView
            tvPBL = itemView.findViewById<View>(R.id.tvPBL) as TextView
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val v : View
        v = LayoutInflater.from(context).inflate(R.layout.list_chart_bl, parent, false)
        return MyViewHolder(v)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.tvPositionBL.text = lstBlChart[position].position.toString()
        holder.tvNameTeamBL.text = lstBlChart[position].team.name
        holder.tvWBL.text = lstBlChart[position].won.toString()
        holder.tvLBL.text = lstBlChart[position].lost.toString()
        holder.tvDBL.text = lstBlChart[position].draw.toString()
        holder.tvPBL.text = lstBlChart[position].points.toString()
        Glide.with(context)
            .load(lstBlChart[position].team.crestUrl)
            .into(holder.civTeamIconBL)


    }

    override fun getItemCount(): Int {
        return lstBlChart.size
    }
}