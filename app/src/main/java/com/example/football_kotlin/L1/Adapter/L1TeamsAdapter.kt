package com.example.football_kotlin.L1.Adapter

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.football_kotlin.L1.ModelL1.Team
import com.example.football_kotlin.PL.Adapter.TeamsAdapterPL
import com.example.football_kotlin.R
import de.hdodenhof.circleimageview.CircleImageView

class L1TeamsAdapter(val context: Context, val L1TeamList : List<Team>) : RecyclerView.Adapter<L1TeamsAdapter.MyViewHolder>() {

    var dialog : Dialog? = null

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvTeamsL1 : TextView
        var civTeamsL1 : CircleImageView
        var rlL1 : RelativeLayout

        init {
            tvTeamsL1 = itemView.findViewById<View>(R.id.tvTeamsL1) as TextView
            civTeamsL1 = itemView.findViewById<View>(R.id.civTeamsL1) as CircleImageView
            rlL1 = itemView.findViewById<View>(R.id.rlitemTeamsL1) as RelativeLayout
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v : View
        v = LayoutInflater.from(context).inflate(R.layout.list_l1_teams_items, parent, false)
        val vHolder : MyViewHolder = MyViewHolder(v)

        //Dialog
        dialog = Dialog(context)
        dialog!!.setContentView(R.layout.dialog_l1)
        vHolder.rlL1.setOnClickListener {
            val tvNameDetailsL1 = dialog!!.findViewById<View>(R.id.tvNameDetailsL1) as TextView
            val tvShortNameDetailsL1 = dialog!!.findViewById<View>(R.id.tvShortNameDetailsL1) as TextView
            val tvTLADetailsL1 = dialog!!.findViewById<View>(R.id.tvTLADetailsL1) as TextView
            val tvAddressDetailsL1 = dialog!!.findViewById<View>(R.id.tvAddressDetailsL1) as TextView
            val tvPhoneDetailsL1 = dialog!!.findViewById<View>(R.id.tvPhoneDetailsL1) as TextView
            val tvWebsiteDetailsL1 = dialog!!.findViewById<View>(R.id.tvWebsiteDetailsL1) as TextView
            val tvEmailDetailsL1 = dialog!!.findViewById<View>(R.id.tvEmailDetailsL1) as TextView
            val tvFoundedDetailsL1 = dialog!!.findViewById<View>(R.id.tvFoundedDetailsL1) as TextView
            val tvVenueDetailsL1 = dialog!!.findViewById<View>(R.id.tvVenueDetailsL1) as TextView
            //------------------------------

            tvNameDetailsL1.text = L1TeamList[vHolder.absoluteAdapterPosition].name
            tvShortNameDetailsL1.text = L1TeamList[vHolder.absoluteAdapterPosition].shortName
            tvTLADetailsL1.text = L1TeamList[vHolder.absoluteAdapterPosition].tla
            tvAddressDetailsL1.text = L1TeamList[vHolder.absoluteAdapterPosition].address
            tvPhoneDetailsL1.text = L1TeamList[vHolder.absoluteAdapterPosition].phone
            tvWebsiteDetailsL1.text = L1TeamList[vHolder.absoluteAdapterPosition].phone
            tvEmailDetailsL1.text = L1TeamList[vHolder.absoluteAdapterPosition].website
            tvFoundedDetailsL1.text = L1TeamList[vHolder.absoluteAdapterPosition].founded.toString()
            tvVenueDetailsL1.text = L1TeamList[vHolder.absoluteAdapterPosition].venue


            dialog!!.show()
        }

        return vHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvTeamsL1.text = L1TeamList[position].name
        Glide.with(context)
            .load(L1TeamList[position].crestUrl)
            .into(holder.civTeamsL1)
    }

    override fun getItemCount(): Int {
        return L1TeamList.size
    }
}