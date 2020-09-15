package com.example.lektion2

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.play_main.*
import kotlinx.android.synthetic.main.quest_menu_fragment.*

class QuestFragment (var changeInt: Int= 0): Fragment() {


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.quest_menu_fragment, container,
            false)

        val listOfLevels= getListOfLevels()
        val recyclerView = view.findViewById<RecyclerView>(R.id.levelsRecyclerView)

        recyclerView.apply {
            layoutManager = GridLayoutManager(activity, 4)
            adapter =
                LevelRecyclerViewAdapter(listOfLevels)
        }


        return view
    }

}