package com.example.lektion2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val listOfElements = listOf(
     Element(R.mipmap.apple, (1..9).random()),
     Element(R.mipmap.apple, (1..9).random()),
     Element(R.mipmap.apple, (1..9).random()),
     Element(R.mipmap.apple, (1..9).random())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        elementsRecyclerView.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=RecyclerViewAdapter()
        }




    }
}