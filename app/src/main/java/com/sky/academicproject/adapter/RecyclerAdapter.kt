package com.sky.academicproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sky.academicproject.R
import com.sky.academicproject.model.NewResponse
import kotlinx.android.synthetic.main.recycler_row.view.*

class RecyclerAdapter(var response: NewResponse) : RecyclerView.Adapter<RecyclerAdapter.ResponseHolder>() {
    class ResponseHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponseHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_row,parent,false)
        return ResponseHolder(view)
    }

    override fun onBindViewHolder(holder: ResponseHolder, position: Int) {
        response.articles?.let {
            holder.itemView.authorTextView.text = it[position].author.toString()
            holder.itemView.articleTextView.text = it!![position].description.toString()
        }
    }

    override fun getItemCount(): Int {
      response.articles?.let {
          return it.size
      }
        return 100
    }

    fun refreshData(newResponse: NewResponse){
        response = newResponse
    }
}