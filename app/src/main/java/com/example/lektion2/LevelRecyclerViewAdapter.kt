package com.example.lektion2

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

var nextLevel: Level? =null
class LevelRecyclerViewAdapter(private val myDataset: MutableList<Level>?) :
    RecyclerView.Adapter<LevelRecyclerViewAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        var levelText = view.findViewById<TextView>(R.id.levelTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): LevelRecyclerViewAdapter.MyViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.element_level_recycler_view, parent, false)

        return MyViewHolder(textView)
    }



    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() : Int{
        return myDataset!!.size
    }


    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: LevelRecyclerViewAdapter.MyViewHolder, position: Int) {

      var level= myDataset!![position]
        val text: String= level!!.level.toString()
        holder.levelText.text=text



        var chechIfAvailable: Boolean= level!!.numberOfCards <= loadAvailableLevels(holder.levelText.context)

        if ( chechIfAvailable ){
        holder.levelText.setOnClickListener{
            level!!.cou()
            showDialogMemoryRules(fm,  level!!.numberOfCards, level!!.numberOfSpan)
        }
        }else{
            holder.levelText.setBackgroundColor(R.color.colorPrimary)
            holder.levelText.setTextColor(R.color.colorPrimaryDark)

        }

    }
}





