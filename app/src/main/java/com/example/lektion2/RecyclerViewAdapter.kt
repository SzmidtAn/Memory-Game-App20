package com.example.lektion2

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlin.coroutines.coroutineContext

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.element_recycle_view, parent, false)
        return ViewHolder(view)

    }




    inner class ViewHolder( view: View) :RecyclerView.ViewHolder(view) {

        var imageElement=view.findViewById<ImageView>(R.id.imageImageView)







    }

    override fun getItemCount(): Int {
        return 9
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {




        var b:Boolean=false
    holder.imageElement.setImageResource(R.mipmap.ic_launcher_round)


        var i= R.mipmap.ic_launcher

        holder.imageElement.setOnClickListener{

        i=R.mipmap.apple
        holder.imageElement.setImageResource(i)

            if (checkIfElementsSame(position)){
                println("Grattir you are the vinner")
            }else
            Handler().postDelayed({
                holder.imageElement.setImageResource(R.mipmap.ic_launcher_round)
            }, 1000)



    }
    }


}


fun checkIfElementsSame(position: Int): Boolean{

    if (position==5){
        return true
    }else{
return false
    }
}

