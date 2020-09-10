package com.example.lektion2

import android.content.Intent
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlin.coroutines.coroutineContext

class RecyclerViewAdapter(animals: MutableList<Element>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {




    private var products: MutableList<Element>? = animals
    val checkElements: MutableList<Element> = ArrayList(2)
    var element1 : Element? =null
    var element2 : Element? =null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.element_recycle_view, parent, false)
        return ViewHolder(view)

    }




    inner class ViewHolder( view: View) :RecyclerView.ViewHolder(view) {

        var imageElement=view.findViewById<ImageView>(R.id.imageImageView)







    }

    override fun getItemCount(): Int {
        return 12
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {




        var element= products?.get(position)
        element!!.elementId=position
        holder.imageElement.setImageResource(R.mipmap.card_back)





        holder.imageElement.setOnClickListener{

checkElements.add(element!!)



            Glide.with(holder.imageElement.getContext())
                .asBitmap()
                .load(element?.imageString)
                .centerCrop()
                .into(holder.imageElement)




            if (checkElements.size > 1){

            element1= checkElements[0]
                element2= checkElements[1]



        if (checkIfElementsSame(element1!!, element2!!, position)){
            println("Grattis you are the vinner")
            element1!!.ifFind=true
            element2!!.ifFind=true






        }else
            Handler().postDelayed({
                holder.imageElement.setImageResource(R.mipmap.card_back)
                bindViewHolder(holder, 2)

            }, 1000)

            checkElements.clear()
            }


            checkIfVinner(this!!.products!!)

    }

        }

}


fun checkIfElementsSame(element1: Element,element2: Element, position: Int): Boolean{

    if (element1.imageString.toString() == element2.imageString.toString()){
        return true
    }else{
return false
    }
}

fun checkIfVinner(list:MutableList<Element>){
    var a=0
    for (i in list){
        if (i.ifFind == true){
            a++
        }
    }

    if (a == 9){
        println("wygrana")
    }


}

