package com.example.lektion2

import android.app.AlertDialog
import android.content.Context
import android.content.Intent

class Level (var level:Int = 0, var numberOfCards:Int = 9, var numberOfSpan: Int = 3, var ifAvailable: Boolean = false) {

    fun cou() {
        when (numberOfCards){
            12 -> numberOfSpan=3
            14 -> numberOfSpan=3
            16 -> numberOfSpan=4
            18 -> numberOfSpan=4
            20 -> numberOfSpan=5
            22 -> numberOfSpan=5
            24 -> numberOfSpan=6
        }


        fun dd(){
            level += 16
        }

    }


     fun makeLevelAvailable(){
        ifAvailable=true
    }



}

