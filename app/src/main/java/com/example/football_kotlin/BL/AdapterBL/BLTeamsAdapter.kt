package com.example.football_kotlin.BL.AdapterBL

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.football_kotlin.BL.ModelBL.Table
import com.example.football_kotlin.BL.ModelBL.TeamX
import com.example.football_kotlin.R
import de.hdodenhof.circleimageview.CircleImageView
import java.util.zip.Inflater

var dialog : Dialog? = null

class BLTeamsAdapter(val context: Context, val lstTeamsBL : List<TeamX>) : RecyclerView.Adapter<BLTeamsAdapter.MyViewHolder>() {
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)  {

        var tvBLTeamsName : TextView
        var civBLTeams : CircleImageView
        var rlBL : RelativeLayout? = null

        init {
            tvBLTeamsName = itemView.findViewById<View>(R.id.tvTeamsBL) as TextView
            civBLTeams = itemView.findViewById<View>(R.id.civTeamsBL) as CircleImageView
            rlBL = itemView.findViewById<View>(R.id.rlitemTeamsBL) as RelativeLayout
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v : View
        v = LayoutInflater.from(context).inflate(R.layout.list_teams_bl, parent, false)
        val vHolder : MyViewHolder = MyViewHolder(v)

        dialog = Dialog(context)
        dialog!!.setContentView(R.layout.dialog_bl)
        vHolder.rlBL?.setOnClickListener {
            val tvNameDetailsBL = dialog!!.findViewById<View>(R.id.tvNameDetailsBL) as TextView
            val tvShortNameDetailsBL = dialog!!.findViewById<View>(R.id.tvShortNameDetailsBL) as TextView
            val tvTLADetailsBL = dialog!!.findViewById<View>(R.id.tvTLADetailsBL) as TextView
            val tvAddressDetailsBL = dialog!!.findViewById<View>(R.id.tvAddressDetailsBL) as TextView
            val tvPhoneDetailsBL = dialog!!.findViewById<View>(R.id.tvPhoneDetailsBL) as TextView
            val tvWebsiteDetailsBL = dialog!!.findViewById<View>(R.id.tvWebsiteDetailsBL) as TextView
            val tvEmailDetailsBL = dialog!!.findViewById<View>(R.id.tvEmailDetailsBL) as TextView
            val tvFoundedDetailsBL = dialog!!.findViewById<View>(R.id.tvFoundedDetailsBL) as TextView
            val tvVenueDetailsBL = dialog!!.findViewById<View>(R.id.tvVenueDetailsBL) as TextView

            // -----------------------------------------------------

            tvNameDetailsBL.text = lstTeamsBL[vHolder.absoluteAdapterPosition].name
            tvShortNameDetailsBL.text = lstTeamsBL[vHolder.absoluteAdapterPosition].shortName
            tvTLADetailsBL.text = lstTeamsBL[vHolder.absoluteAdapterPosition].tla
            tvAddressDetailsBL.text = lstTeamsBL[vHolder.absoluteAdapterPosition].address
            tvPhoneDetailsBL.text = lstTeamsBL[vHolder.absoluteAdapterPosition].phone
            tvWebsiteDetailsBL.text = lstTeamsBL[vHolder.absoluteAdapterPosition].phone
            tvEmailDetailsBL.text = lstTeamsBL[vHolder.absoluteAdapterPosition].website
            tvFoundedDetailsBL.text = lstTeamsBL[vHolder.absoluteAdapterPosition].founded.toString()
            tvVenueDetailsBL.text = lstTeamsBL[vHolder.absoluteAdapterPosition].venue

            dialog!!.show()

        }

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