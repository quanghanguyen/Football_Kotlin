package com.example.football_kotlin.SA.AdapterSA

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.football_kotlin.R
import com.example.football_kotlin.SA.ModelSA.Table
import de.hdodenhof.circleimageview.CircleImageView

class ChartAdapter (val context: Context, val lstSAChart : List<Table>) :
    RecyclerView.Adapter<ChartAdapter.MyViewHolder> (){

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvPositionSA: TextView
        val tvNameTeamSA: TextView
        val civTeamIconSA: CircleImageView
        val tvWSA: TextView
        val tvLSA: TextView
        val tvDSA: TextView
        val tvPSA: TextView

        init {
            tvPositionSA = itemView.findViewById(R.id.tvPositionSA)
            tvNameTeamSA = itemView.findViewById(R.id.tvNameTeamSA)
            civTeamIconSA = itemView.findViewById(R.id.civTeamIconSA)
            tvWSA = itemView.findViewById(R.id.tvWSA)
            tvLSA = itemView.findViewById(R.id.tvLSA)
            tvDSA = itemView.findViewById(R.id.tvDSA)
            tvPSA = itemView.findViewById(R.id.tvPSA)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v : View
        v = LayoutInflater.from(context).inflate(R.layout.list_chart_sa, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvPositionSA.text = lstSAChart[position].position.toString()
        holder.tvNameTeamSA.text = lstSAChart[position].team.name
        holder.tvWSA.text = lstSAChart[position].won.toString()
        holder.tvLSA.text = lstSAChart[position].lost.toString()
        holder.tvDSA.text = lstSAChart[position].draw.toString()
        holder.tvPSA.text = lstSAChart[position].points.toString()
        Glide.with(context)
            .load(lstSAChart[position].team.crestUrl)
            .into(holder.civTeamIconSA)


    }

    override fun getItemCount(): Int {

        return lstSAChart.size

    }


}