package com.example.lektion2

import android.media.MediaPlayer
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.lektion2.RecyclerViewAdapter.ViewHolder
import kotlinx.android.synthetic.main.element_recycle_view.view.*
import kotlinx.android.synthetic.main.home_activity.*
import kotlin.collections.ArrayList


var movesInGame:Int=0
var cardsNumToFunCheck:Int= 0
var mediaPlayer: MediaPlayer? = null

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

        holder.imageElement.isEnabled=false
        val element = products?.get(position)
        element!!.elementId = position


        element.turnCard(holder.imageElement, element.imageString)

        Handler().postDelayed({
        holder.imageElement.isEnabled=true
            element.turnCard(holder.imageElement, element.imageDefault)

            mediaPlayerBackgrundMusic?.stop()

        }, 3000)





            holder.imageElement.setOnClickListener { it ->







                val context = holder.imageElement.context



        if (!element.ifFind) {




                mediaPlayer = MediaPlayer.create(context, R.raw.carfli)
                mediaPlayer?.start() // no need to call prepare(); create() does that for you



                if (checkElements.size <2) {



                checkElements.add(element)
                }


                element.turnCard(holder.imageElement, element.imageString)

                element.ifFind=true
                if (checkElements.size >1) {



                    for (i in products!!) {
                        val getViewForElements = mRecyclerList?.findViewHolderForAdapterPosition(i.elementId)?.itemView?.imageImageView
                        getViewForElements!!.isEnabled = false
                    }


                    countPoints()
            saveElementsToCompare()

                    if (checkIfElementsSame(element1!!, element2!!)) {
                        val mediaPlayer1 = MediaPlayer.create(context, R.raw.bing)
                        mediaPlayer1?.start()
                        setIfFindBoolean(element1, true)
                        setIfFindBoolean(element2, true)


                        for (i in products!!) {
                            val getViewForElements = mRecyclerList?.findViewHolderForAdapterPosition(i.elementId)?.itemView?.imageImageView
                            getViewForElements!!.isEnabled = true
                        }

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
            getViewForElements!!.isEnabled = true
            if (!i.ifFind){
                getViewForElements.let { it1 -> i.turnCard(it1, i.imageDefault) }
            } else if (i.ifFind){
  
            }
        }
    }

    private fun setIfFindBoolean(element: Element?, b: Boolean) {
        products!!.get(element!!.elementId).ifFind = b
    }


    private fun saveElementsToCompare() {
        element1 = checkElements[0]
        element2 = checkElements[1]

        checkElements.removeAll(checkElements)
    }

}







