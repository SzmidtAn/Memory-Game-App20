package com.example.lektion2

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lektion2.RecyclerViewAdapter.ViewHolder
import kotlinx.android.synthetic.main.element_recycle_view.view.*
import kotlin.collections.ArrayList


var gamesPoints:Int=0
class RecyclerViewAdapter(mRecyclerList: RecyclerView?, animals: MutableList<Element>) :
    RecyclerView.Adapter<ViewHolder>() {


    private val mRecyclerList: RecyclerView? = mRecyclerList

    private var products: MutableList<Element>? = animals
    val checkElements: MutableList<Element> = ArrayList(2)
    var element1: Element? = null
    var element2: Element? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.element_recycle_view, parent, false)


        return ViewHolder(view)

    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var imageElement = view.findViewById<ImageView>(R.id.imageImageView)

    }

    override fun getItemCount(): Int {
        return 12
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var element = products?.get(position)
        element!!.elementId = position


        Glide.with(holder.imageElement.context)
            .asBitmap()
            .load(products?.get(position)!!.imageString)
            .centerCrop()
            .into(holder.imageElement)

        Handler().postDelayed({

            Glide.with(holder.imageElement.context)
                .asBitmap()
                .load(R.mipmap.quesstion)
                .centerCrop()
                .into(holder.imageElement)
        }, 3000)


        holder.imageElement.setOnClickListener { it ->

            val context = holder.imageElement.context

            checkElements.add(element)

            Glide.with(holder.imageElement.context)
                .asBitmap()
                .load(element.imageString)
                .centerCrop()
                .into(holder.imageElement)


                if (checkElements.size == 2) {

                    gamesPoints++

                    element1 = checkElements[0]
                    element2 = checkElements[1]

                    if (checkIfElementsSame(element1!!, element2!!)) {
                        println("Grattis you are the vinner")

                        products!!.get(element1!!.elementId).ifFind= true
                        products!!.get(element2!!.elementId).ifFind= true

                    } else

                        Handler().postDelayed({



                            var elementsContext= mRecyclerList!!.findViewHolderForAdapterPosition(element1!!.elementId)!!.itemView.imageImageView
                            var element2sContext= mRecyclerList!!.findViewHolderForAdapterPosition(element2!!.elementId)!!.itemView.imageImageView


                            Glide.with(elementsContext.context)
                                .asBitmap()
                                .load(R.mipmap.quesstion)
                                .centerCrop()
                                .into(elementsContext)

                            Glide.with(elementsContext.context)
                                .asBitmap()
                                .load(R.mipmap.quesstion)
                                .centerCrop()
                                .into(element2sContext)

                        }, 1000)

                    checkElements.clear()
                }

                if (checkIfVinner(this.products!!)) {
                    showDialog(context)
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
        if (a == list.size) {
            return true
        }
        return false
    }

    private fun showDialog(context: Context) {
        val builder = AlertDialog.Builder(context)
        builder.setMessage("Potrzebowałeś $gamesPoints ruchów, aby ukończyć rundę.\n\nNiezła robota!")

        builder.setTitle("Gratulacje!")
        builder.setIcon(R.mipmap.fruit)
        builder.setCancelable(false)
        builder.setNegativeButton("Graj dalej") { dialogInterface, i ->
            val mIntent = Intent(context, MainActivity::class.java)
            context.startActivity(mIntent)
        }
        gamesPoints=0
        builder.create().show()
    }




