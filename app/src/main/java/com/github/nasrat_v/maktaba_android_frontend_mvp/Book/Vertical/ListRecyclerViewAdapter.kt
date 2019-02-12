package com.github.nasrat_v.maktaba_android_frontend_mvp.Book.Vertical

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.github.nasrat_v.maktaba_android_frontend_mvp.Book.Horizontal.RecyclerViewAdapter
import com.github.nasrat_v.maktaba_android_frontend_mvp.ICallback.ITabFragmentClickCallback
import com.github.nasrat_v.maktaba_android_frontend_mvp.R

class ListRecyclerViewAdapter(private var context: Context, private var list: ArrayList<ListModel>,
                              private var mTabFragmentClickCallback: ITabFragmentClickCallback
)
    : RecyclerView.Adapter<ListRecyclerViewAdapter.ViewHolder>() {

    private var viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(container: ViewGroup, p1: Int): ViewHolder {
        val rootView =  LayoutInflater.from(container.context).inflate(R.layout.vertical_recyclerview_book, container, false)
        return ViewHolder(
            rootView
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list[position]
        val title = model.title
        val horizontalRecyclerViewAdapter =
            RecyclerViewAdapter(
                context,
                model.bookHorizontalModels
            )

        horizontalRecyclerViewAdapter.setTabFragmentClickCallback(mTabFragmentClickCallback)
        holder.mTitle.text = title
        holder.horizontalRecyclerView.setRecycledViewPool(viewPool)
        holder.horizontalRecyclerView.setHasFixedSize(true)
        holder.horizontalRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.horizontalRecyclerView.adapter = horizontalRecyclerViewAdapter
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mTitle = itemView.findViewById<TextView>(R.id.vertical_title)!!
        var horizontalRecyclerView = itemView.findViewById<RecyclerView>(R.id.horizontal_recyclerview)!!
    }
}