package com.github.nasrat_v.maktaba_android_frontend_mvp.Listable.Genre.Vertical

import android.content.Context
import android.os.SystemClock
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.github.nasrat_v.maktaba_android_frontend_mvp.Listable.Genre.GModel
import com.github.nasrat_v.maktaba_android_frontend_mvp.ICallback.IRecommendedAdditionalClickCallback
import com.github.nasrat_v.maktaba_android_frontend_mvp.ICallback.ISectionAdditionalClickCallback
import com.github.nasrat_v.maktaba_android_frontend_mvp.R

class GSRecyclerViewAdapter(
    private var context: Context, private var list: ArrayList<GModel>,
    private var mAdditionalClickCallback: ISectionAdditionalClickCallback
) : RecyclerView.Adapter<GSRecyclerViewAdapter.ViewHolder>() {

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
            Toast.makeText(context, model.name, Toast.LENGTH_SHORT).show()
            mAdditionalClickCallback.sectionEventButtonClicked(list[position])
        }
    }

    class ViewHolder(genreView: View) : RecyclerView.ViewHolder(genreView) {
        var mSectionButton = genreView.findViewById<TextView>(R.id.button_section)!!
    }
}