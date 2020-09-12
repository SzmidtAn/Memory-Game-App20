package com.example.lektion2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lektion2.RecyclerViewAdapter.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.Collections.shuffle
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var inpoin: Int = 0

    private val listOfElements = listOf(
        Element(R.mipmap.orange, (1..9).random()),
        Element(R.mipmap.orange, (1..9).random()),
        Element(R.mipmap.fruit, (1..9).random()),
        Element(R.mipmap.fruit, (1..9).random()),
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
        setContentView(R.layout.activity_main)


        resumeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
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
            layoutManager = GridLayoutManager(this@MainActivity, 3)
            adapter =
                RecyclerViewAdapter(elementsRecyclerView, listOfElements as MutableList<Element>)
        }

        point()

    }


    fun point() {
        inpoin++

        val bundle = intent.extras
        var samplename: String = "a"
        if (bundle != null) {

            samplename = intent.getStringExtra("point").toString()

        }

    }

}