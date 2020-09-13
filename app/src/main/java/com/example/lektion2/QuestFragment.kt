package com.example.lektion2

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class QuestFragment (var changeInt: Int= 0): Fragment() {


     var listOfLevels: MutableList<Level>? = ArrayList(0)



    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.quest_menu_fragment, container,
            false)



        for (i in 1..16){
        listOfLevels!!.add(Level(i+changeInt))
        }


        val activity = activity as Context
        val recyclerView = view.findViewById<RecyclerView>(R.id.levelsRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(activity, 4)
        recyclerView.adapter = LevelRecyclerViewAdapter(listOfLevels)
        return view
    }


}