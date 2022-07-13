package com.sirius.test_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load

class CommentAdapter(
    private val dataSet: List<ReviewModel>
) : RecyclerView.Adapter<CommentAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.imageView3) as ImageView
        val nameAuthorCom: TextView = view.findViewById(R.id.nameAuthorCom) as TextView
        val dataComment: TextView = view.findViewById(R.id.data_comment) as TextView
        val textComment: TextView = view.findViewById(R.id.text_comment) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.comment, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.load(dataSet[position].userImage)
        holder.nameAuthorCom.text = dataSet[position].userName
        holder.dataComment.text = dataSet[position].date
        holder.textComment.text = dataSet[position].message
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}