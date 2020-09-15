package com.example.lektion2

import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.lektion2.RecyclerViewAdapter.ViewHolder
import kotlinx.android.synthetic.main.element_recycle_view.view.*
import kotlin.collections.ArrayList


var movesInGame:Int=0
var cardsNumToFunCheck:Int= 0

class RecyclerViewAdapter(private val mRecyclerList: RecyclerView?, list: MutableList<Element>, cardsCount:Int = 12) :
    RecyclerView.Adapter<ViewHolder>() {


    private var products: MutableList<Element>? = list
    val checkElements: MutableList<Element> = ArrayList(2)
    var element1: Element? = null
    var element2: Element? = null
    var cardsNum:Int= cardsCount



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.element_recycle_view, parent, false)

        return ViewHolder(view)

    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var imageElement = view.findViewById<ImageView>(R.id.imageImageView)

    }

    override fun getItemCount(): Int {
        cardsNumToFunCheck=cardsNum
        return cardsNum
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val element = products?.get(position)
        element!!.elementId = position


        element.turnCard(holder.imageElement, element.imageString)

        Handler().postDelayed({
            element.turnCard(holder.imageElement, element.imageDefault)
        }, 3000)



            holder.imageElement.setOnClickListener { it ->
        if (!element.ifFind) {
                val context = holder.imageElement.context

                checkElements.add(element)
                element.turnCard(holder.imageElement, element.imageString)

                if (checkElements.size >1) {
                element.ifFind=true
                    countPoints()
            saveElementsToCompare()

                    if (checkIfElementsSame(element1!!, element2!!)) {
                        setIfFindBoolean(element1, true)
                        setIfFindBoolean(element2, true)
                    } else {
                        setIfFindBoolean(element1, false)
                        setIfFindBoolean(element2, false)
                    }


                    Handler().postDelayed({
                        setImageAfterChecking()
                    }, 600)
                }
                checkIfWinner(this.products!!, context)
            }
                }
        }


    private fun setImageAfterChecking() {
        for (i in products!!){
            val getViewForElements= mRecyclerList?.findViewHolderForAdapterPosition(i.elementId)?.itemView?.imageImageView
            if (!i.ifFind){
                getViewForElements?.let { it1 -> i.turnCard(it1, i.imageDefault) }
            } else if (i.ifFind){
                getViewForElements!!.visibility=View.GONE
            }
        }
    }

    private fun setIfFindBoolean(element: Element?, b: Boolean) {
        products!!.get(element!!.elementId).ifFind = b
    }


    private fun saveElementsToCompare() {
        element1 = checkElements[0]
        element2 = checkElements[1]

        checkElements.clear()
    }

}







