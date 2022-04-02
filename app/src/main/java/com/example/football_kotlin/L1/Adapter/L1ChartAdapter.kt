package com.example.football_kotlin.L1.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.football_kotlin.L1.ModelL1.Table
import com.example.football_kotlin.R
import de.hdodenhof.circleimageview.CircleImageView
import org.w3c.dom.Text

class L1ChartAdapter(val context: Context, val lstChartL1 : List<Table>) : RecyclerView.Adapter<L1ChartAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvPositionL1: TextView
        val tvNameTeamL1: TextView
        val civTeamIconL1: CircleImageView
        val tvWL1: TextView
        val tvLL1: TextView
        val tvDL1: TextView
        val tvPL1: TextView

        init {
            tvPositionL1 = itemView.findViewById<View>(R.id.tvPositionL1) as TextView
            tvNameTeamL1 = itemView.findViewById<View>(R.id.tvNameTeamL1) as TextView
            civTeamIconL1 = itemView.findViewById<View>(R.id.civTeamIconL1) as CircleImageView
            tvWL1 = itemView.findViewById<View>(R.id.tvWL1) as TextView
            tvLL1 = itemView.findViewById<View>(R.id.tvLL1) as TextView
            tvDL1 = itemView.findViewById<View>(R.id.tvDL1) as TextView
            tvPL1 = itemView.findViewById<View>(R.id.tvPL1) as TextView
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v : View
        v = LayoutInflater.from(context).inflate(R.layout.list_chart_l1, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.tvPositionL1.text = lstChartL1[position].position.toString()
        holder.tvNameTeamL1.text = lstChartL1[position].team.name
        holder.tvWL1.text = lstChartL1[position].won.toString()
        holder.tvLL1.text = lstChartL1[position].lost.toString()
        holder.tvPL1.text = lstChartL1[position].points.toString()
        holder.tvDL1.text = lstChartL1[position].draw.toString()
        //Glide
        Glide.with(context)
            .load(lstChartL1[position].team.crestUrl)
            .into(holder.civTeamIconL1)

    }

    override fun getItemCount(): Int {

        return lstChartL1.size

    }

}