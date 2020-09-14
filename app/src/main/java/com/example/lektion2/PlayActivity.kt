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

    private val listOfElements = getListOfElements()

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.play_main)


        resumeButton.setOnClickListener {
            showDialog(this)
        }


        val numberOfCardsToPlay= intent.getIntExtra("ww", 12)
        val numberOfSpanToPlay= intent.getIntExtra("rr", 3)

        val cards=numberOfCardsToPlay/2

        val animals: MutableList<Element> = ArrayList(9)
        val random = Random()
        for (i in 1..cards) {
            var randomAnimal: Element = listOfElements[random.nextInt(listOfElements.size)]

            var checkBoolean = false
            while (checkBoolean == false){

            if (checkIfElementAlreadyExists(randomAnimal.elementId, animals) && i >1){
            randomAnimal=  listOfElements[random.nextInt(listOfElements.size)]
                checkIfElementAlreadyExists(randomAnimal.elementId, animals)
            }else{
                checkBoolean=true
            }

            }

            val animal = Element(randomAnimal.imageString, randomAnimal.elementId)
            val animal2 = Element(randomAnimal.imageString, randomAnimal.elementId)
            animals.add(animal)
            animals.add(animal2)
            checkBoolean=false
        }


        shuffle(animals)



        elementsRecyclerView.apply {
            layoutManager = GridLayoutManager(this@PlayActivity, numberOfSpanToPlay)
            adapter =
                RecyclerViewAdapter(elementsRecyclerView,
                    animals, numberOfCardsToPlay)
        }

        textPoint= findViewById<TextView>(R.id.pointsTextView)
        countPoints()




    }

    private fun checkIfElementAlreadyExists(imageString: Int, animals: MutableList<Element>): Boolean {
        for (i in animals){
            if (imageString == i.elementId){
                return true
            }
        }
        return false
    }

    override fun onBackPressed() {
       showDialog(this)
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


