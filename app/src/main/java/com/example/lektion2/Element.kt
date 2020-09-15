package com.example.lektion2

import android.view.MotionEvent


class Element (var imageString: Int, var elementId:Int, var ifFind:Boolean = false) {


     fun onTouchEvent(event: MotionEvent?): Boolean {
        when( event?.action) {
            MotionEvent.ACTION_DOWN -> {
                imageString = R.drawable.ic_launcher_background
            }
            MotionEvent.ACTION_UP -> {
                imageString=R.drawable.ic_launcher_background

            }
        }
        return true
    }


}