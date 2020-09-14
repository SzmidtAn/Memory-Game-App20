package com.example.lektion2

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lektion2.RecyclerViewAdapter.ViewHolder
import kotlinx.android.synthetic.main.element_recycle_view.view.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList
import kotlin.coroutines.coroutineContext


var gamesPoints:Int=0
var cardsNumToFunChech:Int= 0
class RecyclerViewAdapter(mRecyclerList: RecyclerView?, list: MutableList<Element>, cardsCount:Int = 12) :
    RecyclerView.Adapter<ViewHolder>() {


    private val mRecyclerList: RecyclerView? = mRecyclerList

    private var products: MutableList<Element>? = list
    val checkElements: MutableList<Element> = ArrayList(2)
    var element1: Element? = null
    var element2: Element? = null
    var element3: Element? = null
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
        cardsNumToFunChech=cardsNum
        return cardsNum
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var element = products?.get(position)
        element!!.elementId = position


        Glide.with(holder.imageElement.context)
            .asBitmap()
            .load(products?.get(position)!!.imageString)
            .fitCenter()
            .into(holder.imageElement)

        Handler().postDelayed({

            Glide.with(holder.imageElement.context)
                .asBitmap()
                .load(R.mipmap.quesstion)
                .centerCrop()
                .into(holder.imageElement)
        }, 3000)




            holder.imageElement.setOnClickListener { it ->




                if (element.ifFind == false) {
                val context = holder.imageElement.context


                    element.ifFind=true

                checkElements.add(element)




                Glide.with(holder.imageElement.context)
                    .asBitmap()
                    .load(element.imageString)
                    .circleCrop()
                    .into(holder.imageElement)



                if (checkElements.size >1) {


                    gamesPoints++

                    countPoints()

                    element1 = checkElements[0]
                    element2 = checkElements[1]

                    checkElements.clear()






                    if (checkIfElementsSame(element1!!, element2!!)) {

                        products!!.get(element1!!.elementId).ifFind = true
                        products!!.get(element2!!.elementId).ifFind = true





                    } else {

                        products!!.get(element1!!.elementId).ifFind = false
                        products!!.get(element2!!.elementId).ifFind = false



                    }

                    for (i in products!!){
                        if (i.ifFind == true){

                            Handler().postDelayed({


                                mRecyclerList!!.findViewHolderForAdapterPosition(i!!.elementId)!!.itemView.imageImageView.visibility=View.GONE
                            }, 600)

                        }
                    }



                    Handler().postDelayed({

                                val con= mRecyclerList!!.findViewHolderForAdapterPosition(element1!!.elementId)!!.itemView.imageImageView
                                val con2= mRecyclerList!!.findViewHolderForAdapterPosition(element2!!.elementId)!!.itemView.imageImageView

                                Glide.with(con.context)
                                    .asBitmap()
                                    .load(R.mipmap.quesstion)
                                    .centerCrop()
                                    .into(con)

                                Glide.with(con2.context)
                                    .asBitmap()
                                    .load(R.mipmap.quesstion)
                                    .centerCrop()
                                    .into(con2)

                        for (i in products!!){
                            if (i.ifFind == false){
                                val con3= mRecyclerList.findViewHolderForAdapterPosition(i.elementId)?.itemView?.imageImageView


                                if (con3 != null) {
                                    Glide.with(con3.context)
                                        .asBitmap()
                                        .load(R.mipmap.quesstion)
                                        .centerCrop()
                                        .into(con3)
                                }


                            }
                        }

                    }, 600)


                }

                if (checkIfVinner(this.products!!)) {
                    showDialog(context)

                }
            }




            }

        }

    }


    fun checkIfElementsSame(element1: Element, element2: Element): Boolean {

        return element1.imageString.toString() == element2.imageString.toString()
    }

    fun checkIfVinner(list: MutableList<Element>): Boolean {
        var a = 0
        for (i in list) {
            if (i.ifFind == true) {
                a++
            }
        }
        if (a == cardsNumToFunChech) {
            return true
        }
        return false
    }

    private fun showDialog(context: Context) {
val builder = AlertDialog.Builder(context)
        builder.setMessage("\nPotrzebowałeś $gamesPoints ruchów, aby ukończyć rundę.\n\nNiezła robota!")

        builder.setTitle("Gratulacje!")
        builder.setIcon(R.mipmap.fruit)
        builder.setCancelable(false)
        builder.setView(R.layout.dialog_vin)
        builder.setNegativeButton("Graj dalej") { dialogInterface, i ->
            val mIntent = Intent(context, HomeActivity::class.java)
            context.startActivity(mIntent)
        }
        gamesPoints=0
        builder.create().show()


    }




