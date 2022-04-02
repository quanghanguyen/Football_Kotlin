package com.example.football_kotlin.PL.Adapter

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.football_kotlin.PL.ModelPL.Team
import com.example.football_kotlin.R
import de.hdodenhof.circleimageview.CircleImageView

class TeamsAdapterPL(val context : Context, val teamsList : List<Team>) : RecyclerView.Adapter<TeamsAdapterPL.ViewHolder>() {

    var dialog : Dialog? = null

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var civTeams : CircleImageView
        var tvTeams : TextView
        var itemTeams : RelativeLayout

        init {
            civTeams = itemView.findViewById<View>(R.id.civTeams) as CircleImageView
            tvTeams = itemView.findViewById<View>(R.id.tvTeams) as TextView
            itemTeams = itemView.findViewById<View>(R.id.rlitemTeams) as RelativeLayout
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View
        v = LayoutInflater.from(context).inflate(R.layout.list_pl_teams_items, parent, false)
        val vHolder : ViewHolder = ViewHolder(v)

        // dialog
        dialog = Dialog(context)
        dialog!!.setContentView(R.layout.dialog_pl)
        vHolder.itemTeams.setOnClickListener {

            val tvNameDetails = dialog!!.findViewById<View>(R.id.tvNameDetails) as TextView
            val tvShortNameDetails = dialog!!.findViewById<View>(R.id.tvShortNameDetails) as TextView
            val tvTLADetails = dialog!!.findViewById<View>(R.id.tvTLADetails) as TextView
            val tvAddressDetails = dialog!!.findViewById<View>(R.id.tvAddressDetails) as TextView
            val tvPhoneDetails = dialog!!.findViewById<View>(R.id.tvPhoneDetails) as TextView
            val tvWebsiteDetails = dialog!!.findViewById<View>(R.id.tvWebsiteDetails) as TextView
            val tvEmailDetails = dialog!!.findViewById<View>(R.id.tvEmailDetails) as TextView
            val tvFoundedDetails = dialog!!.findViewById<View>(R.id.tvFoundedDetails) as TextView
            val tvVenueDetails = dialog!!.findViewById<View>(R.id.tvVenueDetails) as TextView


            // -------------------------------------------------------------

            tvNameDetails.text = teamsList[vHolder.absoluteAdapterPosition].name
            tvShortNameDetails.text = teamsList[vHolder.absoluteAdapterPosition].shortName
            tvTLADetails.text = teamsList[vHolder.absoluteAdapterPosition].tla
            tvAddressDetails.text = teamsList[vHolder.absoluteAdapterPosition].address
            tvPhoneDetails.text = teamsList[vHolder.absoluteAdapterPosition].phone
            tvWebsiteDetails.text = teamsList[vHolder.absoluteAdapterPosition].website
            tvEmailDetails.text = teamsList[vHolder.absoluteAdapterPosition].email
            tvFoundedDetails.text = teamsList[vHolder.absoluteAdapterPosition].founded.toString()
            tvVenueDetails.text = teamsList[vHolder.absoluteAdapterPosition].venue

            dialog!!.show()
        }

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