package com.example.lektion2

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.widget.Chronometer
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.play_main.*
import java.util.*
import java.util.Collections.shuffle
import kotlin.collections.ArrayList


var fmf: FragmentManager? =null
var textPoint: TextView? =null
var timeView: Chronometer? =null

class PlayActivity : AppCompatActivity() {

    private val listOfElements = getListOfElements()

    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.play_main)




        resumeButton.setOnClickListener {
            showDialogResume(this)
        }

        fmf=supportFragmentManager


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
            adapter = RecyclerViewAdapter(elementsRecyclerView, animals, numberOfCardsToPlay)



        }

        textPoint= findViewById<TextView>(R.id.pointsTextView)
        timeView= findViewById<TextView>(R.id.timeDialogWinTextView) as Chronometer?

        countPoints()
        startTime()









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
       showDialogResume(this)
    }



}

    @SuppressLint("SetTextI18n")
    fun countPoints(){
        movesInGame++
        textPoint!!.text= "MOVES: $movesInGame"
}




fun checkIfWinner(list: MutableList<Element>, context: Context): Boolean {
    var a = 0
    for (i in list) {
        if (i.ifFind == true) {
            a++
        }
    }
    if (a == cardsNumToFunCheck) {
        timeView!!.stop()
        showDialogWinner(context, fmf)
        saveScore(context, movesInGame)


        return true
    }
    return false
}

fun saveScore(context: Context, score: Int) {
    val sharedPreferences = context.getSharedPreferences("YOUR_PACKAGE_NAME", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()

    if ((cardsNumToFunCheck+2) > loadAvailableLevels(context)){
        editor.putInt("levels", (cardsNumToFunCheck+2))
    }

    if (movesInGame < loadScore(context)){
        editor.putInt(cardsNumToFunCheck.toString(), movesInGame)

    }

    editor.apply()
}

fun loadScore(context: Context?): Int {
    val sharedPreferences = context?.getSharedPreferences("YOUR_PACKAGE_NAME", Context.MODE_PRIVATE)
    return sharedPreferences?.getInt(cardsNumToFunCheck.toString(), 1000)!!
}

fun loadAvailableLevels(context: Context?): Int {
    val sharedPreferences = context?.getSharedPreferences("YOUR_PACKAGE_NAME", Context.MODE_PRIVATE)
    return sharedPreferences?.getInt("levels", 7)!!
}


public fun showDialogResume(context: Context) {

        timeView?.stop()
        val builder = AlertDialog.Builder(context)
        builder.setMessage(context.getString(R.string.are_y_sure_stop_game))
        builder.setTitle(context.getString(R.string.pause))
        builder.setIcon(R.drawable.fruit)
        builder.setCancelable(false)
        builder.setCancelable(true)
        builder.setNegativeButton(context.getString(R.string.continue_playing)){ dialogInterface, i ->
            timeView?.start()

        }
        builder.setPositiveButton(context.getString(R.string.go_to_menu)) { dialogInterface, i ->
            movesInGame=0
            val mIntent = Intent(context, HomeActivity::class.java)
            context.startActivity(mIntent)
        }
        builder.create().show()


    }





public fun showDialogWinner(context: Context, fm: FragmentManager?) {
    var dialogfragm=DialogFragmentWinner()

    mediaPlayer = MediaPlayer.create(context, R.raw.yay)
    mediaPlayer?.start() // no need to call prepare(); create() does that for you


    fm?.let { dialogfragm.show(it, "fef") }

}

private fun startTime() {
    timeView?.base = SystemClock.elapsedRealtime()
    timeView?.start()
}


fun checkIfElementsSame(element1: Element, element2: Element): Boolean {
    return element1.imageString.toString() == element2.imageString.toString()
}



