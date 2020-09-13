package com.example.lektion2

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.play_main.*
import java.util.*
import java.util.Collections.shuffle
import kotlin.collections.ArrayList

var textPoint: TextView? =null

class PlayActivity : AppCompatActivity() {

    private val listOfElements = listOf(
        Element(R.mipmap.orange, (1..9).random()),
        Element(R.mipmap.orange, (1..9).random()),
        Element(R.mipmap.watermelon, (1..9).random()),
        Element(R.mipmap.watermelon, (1..9).random()),
        Element(R.mipmap.banana, (1..9).random()),
        Element(R.mipmap.banana, (1..9).random()),
        Element(R.mipmap.kiwiii, (1..9).random()),
        Element(R.mipmap.kiwiii, (1..9).random()),
        Element(R.mipmap.apple, (1..9).random()),
        Element(R.mipmap.apple, (1..9).random()),
        Element(R.mipmap.pomegranate, (1..9).random()),
        Element(R.mipmap.pomegranate, (1..9).random())
    )

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.play_main)


        resumeButton.setOnClickListener {
            showDialog(this)


        }


        val animals: MutableList<Element> = ArrayList(9)
        val random = Random()
        for (i in 0..6) {
            val randomAnimal: Element = listOfElements[random.nextInt(listOfElements.size)]
            val animal = Element(randomAnimal.imageString, randomAnimal.elementId)
            animals.add(animal)
            animals.add(animal)
        }

        shuffle(listOfElements)


        elementsRecyclerView.apply {
            layoutManager = GridLayoutManager(this@PlayActivity, 3)
            adapter =
                RecyclerViewAdapter(elementsRecyclerView, listOfElements as MutableList<Element>)
        }

        textPoint= findViewById<TextView>(R.id.pointsTextView)
        countPoints()







    }

    override fun onBackPressed() {
       showDialog(this)
    }


fun tt(){

}



}

    @SuppressLint("SetTextI18n")
    fun countPoints(){
        textPoint!!.text= "Liczba ruchów: $gamesPoints"
}



private fun showDialog(context: Context) {
    val builder = AlertDialog.Builder(context)
    builder.setMessage("\nJesteś pewny, że chcesz zakończyć grę?")
    builder.setTitle("PAUSE")
    builder.setIcon(R.mipmap.fruit)
    builder.setCancelable(false)
    builder.setView(R.layout.dialog_vin)
    builder.setCancelable(true)
    builder.setNegativeButton("Graj dalej"){dialogInterface, i ->

    }
    builder.setPositiveButton("Idż do menu") { dialogInterface, i ->
    gamesPoints=0
        val mIntent = Intent(context, HomeActivity::class.java)
        context.startActivity(mIntent)
    }
    builder.create().show()


}


