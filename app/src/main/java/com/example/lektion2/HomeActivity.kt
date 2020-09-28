package com.example.lektion2

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.dialog_winner.view.*
import kotlinx.android.synthetic.main.home_activity.*
import kotlin.system.exitProcess

class HomeActivity : AppCompatActivity(){

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)


        questButton.setOnClickListener{

            mediaPlayer = MediaPlayer.create(this, R.raw.clickbutton)
            mediaPlayer?.start() // no need to call prepare(); create() does that for you

            val mIntent = Intent(this, QuestActivity::class.java)
            startActivity(mIntent)

        }

        quickGamebutton.setOnClickListener {
            mediaPlayer = MediaPlayer.create(this, R.raw.clickbutton)
            mediaPlayer?.start() // no need to call prepare(); create() does that for you
            var fm=supportFragmentManager
   showDialogMemoryRules(fm, 12, 3)

     }

        logo2imageView.startAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left))


        if (mediaPlayerBackgrundMusic == null){

        playBackgrundMusic()
        }

    }

    fun playBackgrundMusic() {

        val intent = Intent(this, BackGroundMusic::class.java)
        startService(intent)

    }


    private var doubleBackToExitPressedOnce = false
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            stopMusic()
            finishAffinity()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()

        Handler().postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)
    }


}



fun showDialogMemoryRules(fm: FragmentManager?, numOfCards: Int, numOfSpan: Int) {
    var dialogfragm=DialogFragmentMemoryRules(numOfCards, numOfSpan)

    fm?.let { dialogfragm.show(it, "fef") }

}



