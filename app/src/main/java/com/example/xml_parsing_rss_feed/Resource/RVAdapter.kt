package com.example.xml_parsing_rss_feed.Resource

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.xml_parsing_rss_feed.Model.Entry
import com.example.xml_parsing_rss_feed.databinding.EntryRowBinding


class RVAdapter(val entries: List<Entry>?) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    class ViewHolder (val binding: EntryRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            EntryRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entry = entries!![position]

        holder.binding.apply {
            tvTitle.text = "Entry#${position+1}: ${entry.title}"
            tvName.text = "By: ${entry.author!!.name!!.substring(entry.author!!.name!!.lastIndexOf("/")+1)}"
            cardView.setOnClickListener {
                Toast.makeText(holder.itemView.context, tvName.text, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int = entries!!.size

}