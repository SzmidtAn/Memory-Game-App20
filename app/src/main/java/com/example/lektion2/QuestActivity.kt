package com.example.lektion2

import android.R.attr.fragment
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.quest_activity.*

        var fm: FragmentManager? =null

class QuestActivity : AppCompatActivity() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quest_activity)



        val listOfLevels= getListOfLevels()
        val recyclerView = findViewById<RecyclerView>(R.id.levelsRecyclerView)

        levelsRecyclerView.apply {
            layoutManager = GridLayoutManager(this@QuestActivity, 4)
            adapter = LevelRecyclerViewAdapter(listOfLevels)
            levelsRecyclerView.isLayoutFrozen=true
        }



        fm=supportFragmentManager





        homeButton.setOnClickListener {
            mediaPlayer = MediaPlayer.create(this, R.raw.clickbutton)
            mediaPlayer?.start() // no need to call prepare(); create() does that for you

            val mIntent = Intent(this, HomeActivity::class.java)
            startActivity(mIntent)
        }





    }








}

