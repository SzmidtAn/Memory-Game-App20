package com.example.lektion2

import android.R.attr.fragment
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.quest_activity.*


class QuestActivity : AppCompatActivity() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quest_activity)

        levelTextView.text= "LEVELS"


      val textFragment = QuestFragment()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container,textFragment)
      transaction.addToBackStack(null)
        transaction.commit()



        backButton.setOnClickListener {
            val textFragment = QuestFragment(0)
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.fragment_container,textFragment)
            transaction.addToBackStack(null)
            transaction.commit()

        }


        rightButton.setOnClickListener {
            val textFragment = QuestFragment(16)
            
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.fragment_container,textFragment)
            transaction.addToBackStack(null)
            transaction.commit()

        }

        homeButton.setOnClickListener {
            val mIntent = Intent(this, HomeActivity::class.java)
            startActivity(mIntent)
        }



    }



}
