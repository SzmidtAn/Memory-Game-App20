package com.example.lektion2

class Game (var poits:Int = 0){

    fun addPoint(): Int{
        poits++
        return poits
    }
}