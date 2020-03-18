package com.shehzad.dataparcel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import java.util.*

class ExampleAdapter(private val mExampleList: ArrayList<ExampleItem>) :
    RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {
    private var mListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        mListener = listener
    }

    class ExampleViewHolder(
        itemView: View,
        listener: OnItemClickListener?
    ) :
        ViewHolder(itemView) {
        var mImageView: ImageView
        var mTextView1: TextView
        var mTextView2: TextView

        init {
            mImageView = itemView.findViewById(R.id.imageView)
            mTextView1 = itemView.findViewById(R.id.textView)
            mTextView2 = itemView.findViewById(R.id.textView2)
            itemView.setOnClickListener {
                if (listener != null) {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExampleViewHolder {
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.example_item, parent, false)
        return ExampleViewHolder(v, mListener)
    }

    override fun onBindViewHolder(
        holder: ExampleViewHolder,
        position: Int
    ) {
        val currentItem = mExampleList[position]
        holder.mImageView.setImageResource(currentItem.getImageResource())
        holder.mTextView1.setText(currentItem.getText1())
        holder.mTextView2.setText(currentItem.getText2())
    }

    override fun getItemCount(): Int {
        return mExampleList.size
    }

}