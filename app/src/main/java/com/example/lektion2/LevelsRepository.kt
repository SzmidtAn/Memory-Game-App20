package com.example.lektion2

fun getListOfLevels(): MutableList<Level>{

    val listOfLevels =  mutableListOf<Level>()

    listOfLevels!!.add(Level(1, 6, 2, true))
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
    listOfLevels!!.add(Level(13, 30, 5))
    listOfLevels!!.add(Level(14, 32, 6))
    listOfLevels!!.add(Level(15, 34, 6))
    listOfLevels!!.add(Level(16, 36, 6))

    return listOfLevels


}
