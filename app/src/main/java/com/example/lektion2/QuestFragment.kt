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


     var listOfLevels: MutableList<Level>? = ArrayList(100)



    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.quest_menu_fragment, container,
            false)



       listOfLevels!!.add(Level(1, 6, 2))
       listOfLevels!!.add(Level(2, 8, 3))
       listOfLevels!!.add(Level(3, 10, 3))
       listOfLevels!!.add(Level(4, 12, 4))
       listOfLevels!!.add(Level(5, 14, 4))
       listOfLevels!!.add(Level(6, 16, 3))
       listOfLevels!!.add(Level(7, 18, 4))
       listOfLevels!!.add(Level(8, 20, 4))
       listOfLevels!!.add(Level(9, 22, 5))
       listOfLevels!!.add(Level(10, 24, 5))
       listOfLevels!!.add(Level(11, 26, 5))
       listOfLevels!!.add(Level(12, 28, 5))
       listOfLevels!!.add(Level(13, 30, 6))
       listOfLevels!!.add(Level(14, 32, 6))
       listOfLevels!!.add(Level(15, 34, 6))
       listOfLevels!!.add(Level(16, 36, 6))




        val activity = activity as Context
        val recyclerView = view.findViewById<RecyclerView>(R.id.levelsRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(activity, 4)
        recyclerView.adapter = LevelRecyclerViewAdapter(listOfLevels)
        return view
    }


}