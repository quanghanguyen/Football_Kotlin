package com.example.football_kotlin.SA.AdapterSA

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.football_kotlin.R
import com.example.football_kotlin.SA.ModelSA.Team
import de.hdodenhof.circleimageview.CircleImageView

var dialog : Dialog? = null

class TeamsAdapter(val context: Context, val lstTeamsSA : List<Team>) : RecyclerView.Adapter<TeamsAdapter.MyViewHolder>() {
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        var tvSATeamsName : TextView? = null
        var civSATeams : CircleImageView? = null
        var rlSA : RelativeLayout? = null

        init {
            tvSATeamsName = itemView.findViewById(R.id.tvTeamsSA)
            civSATeams = itemView.findViewById<View>(R.id.civTeamsSA) as CircleImageView
            rlSA = itemView.findViewById<View>(R.id.rlitemTeamsSA) as RelativeLayout
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v : View
        v = LayoutInflater.from(context).inflate(R.layout.list_teams_sa, parent, false)
        val vHolder : MyViewHolder = MyViewHolder(v)

        dialog = Dialog(context)
        dialog!!.setContentView(R.layout.dialog_sa)

        vHolder.rlSA?.setOnClickListener {
            val tvNameDetailsSA = dialog!!.findViewById<View>(R.id.tvNameDetailsSA) as TextView
            val tvShortNameDetailsSA = dialog!!.findViewById<View>(R.id.tvShortNameDetailsSA) as TextView
            val tvTLADetailsSA = dialog!!.findViewById<View>(R.id.tvTLADetailsSA) as TextView
            val tvAddressDetailsSA = dialog!!.findViewById<View>(R.id.tvAddressDetailsSA) as TextView
            val tvPhoneDetailsSA = dialog!!.findViewById<View>(R.id.tvPhoneDetailsSA) as TextView
            val tvWebsiteDetailsSA = dialog!!.findViewById<View>(R.id.tvWebsiteDetailsSA) as TextView
            val tvEmailDetailsSA = dialog!!.findViewById<View>(R.id.tvEmailDetailsSA) as TextView
            val tvFoundedDetailsSA = dialog!!.findViewById<View>(R.id.tvFoundedDetailsSA) as TextView
            val tvVenueDetailsSA = dialog!!.findViewById<View>(R.id.tvVenueDetailsSA) as TextView

            // ------------------------------------------------------------------------------------

            tvNameDetailsSA.text = lstTeamsSA[vHolder.absoluteAdapterPosition].name
            tvShortNameDetailsSA.text = lstTeamsSA[vHolder.absoluteAdapterPosition].shortName
            tvTLADetailsSA.text = lstTeamsSA[vHolder.absoluteAdapterPosition].tla
            tvAddressDetailsSA.text = lstTeamsSA[vHolder.absoluteAdapterPosition].address
            tvPhoneDetailsSA.text = lstTeamsSA[vHolder.absoluteAdapterPosition].phone
            tvWebsiteDetailsSA.text = lstTeamsSA[vHolder.absoluteAdapterPosition].phone
            tvEmailDetailsSA.text = lstTeamsSA[vHolder.absoluteAdapterPosition].website
            tvFoundedDetailsSA.text = lstTeamsSA[vHolder.absoluteAdapterPosition].founded.toString()
            tvVenueDetailsSA.text = lstTeamsSA[vHolder.absoluteAdapterPosition].venue

            dialog!!.show()

        }

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