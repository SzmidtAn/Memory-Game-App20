package com.example.lektion2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.home_activity.*

class HomeActivity : AppCompatActivity(){

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)


        questButton.setOnClickListener{
            val mIntent = Intent(this, QuestActivity::class.java)
            startActivity(mIntent)
        }

        quickGamebutton.setOnClickListener {
            var fm=supportFragmentManager
   showDialogMemoryRules(fm, 12, 3)

     }



        playBackgrundMusic()

    }

    fun playBackgrundMusic() {

        val intent = Intent(this, BackGroundMusic::class.java)
        startService(intent)

    }


}


fun showDialogMemoryRules(fm: FragmentManager?, numOfCards: Int, numOfSpan: Int) {
    var dialogfragm=DialogFragmentMemoryRules(numOfCards, numOfSpan)

    fm?.let { dialogfragm.show(it, "fef") }

}

fun stopMusic(){

}


