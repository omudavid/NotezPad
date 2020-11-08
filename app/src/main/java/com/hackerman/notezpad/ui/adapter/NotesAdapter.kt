package com.hackerman.notezpad.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextClock
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hackerman.notezpad.R
import com.hackerman.notezpad.ui.model.Note
import java.util.zip.Inflater

class NotesAdapter(var list:List<Note>, var clicker:ClickListener)
    : RecyclerView.Adapter<NotesAdapter.ViewHolder>()
{

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        private val date:TextView = itemView.findViewById(R.id.note_date)
        private val title:TextView = itemView.findViewById(R.id.note_title)
        private val body: TextView = itemView.findViewById(R.id.note_bodySnippet)

        fun initialize(currentItem:Note,clicker: ClickListener){
            date.text = currentItem.id.toString()
            title.text = currentItem.title
            body.text = currentItem.body

            itemView.setOnClickListener {
                clicker.itemClick(currentItem,adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.note_item_template,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]
        holder.initialize(currentItem,clicker)
    }

    override fun getItemCount() = list.size


}

interface ClickListener{
    fun itemClick(currentItem: Note,position: Int)
}