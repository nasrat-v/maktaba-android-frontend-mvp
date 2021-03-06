package com.github.nasrat_v.yaba_demo.Listable.Genre.Vertical

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.github.nasrat_v.yaba_demo.Listable.Genre.GModel
import com.github.nasrat_v.yaba_demo.ICallback.ISectionAdditionalClickCallback
import com.github.nasrat_v.yaba_demo.R

class GSRecyclerViewAdapter(
    private var context: Context, private var list: ArrayList<GModel>,
    private var mAdditionalClickCallback: ISectionAdditionalClickCallback
) : androidx.recyclerview.widget.RecyclerView.Adapter<GSRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(container: ViewGroup, p1: Int): ViewHolder {
        val rootView =
            LayoutInflater.from(container.context).inflate(R.layout.vertical_recyclerview_section, container, false)
        return ViewHolder(
            rootView
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list[position]

        holder.mSectionButton.text = (model.name + " (" + model.nb + ')')
        holder.mSectionButton.setOnClickListener {
            mAdditionalClickCallback.sectionEventButtonClicked(list[position])
        }
    }

    class ViewHolder(genreView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(genreView) {
        var mSectionButton = genreView.findViewById<TextView>(R.id.button_section)!!
    }
}