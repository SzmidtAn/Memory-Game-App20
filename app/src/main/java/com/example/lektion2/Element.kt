package com.example.lektion2

import android.widget.ImageView
import com.bumptech.glide.Glide


class Element (var imageString: Int, var elementId:Int, var ifFind:Boolean = false,  val imageDefault: Int = R.mipmap.quesstion) {


    fun turnCard(imageView: ImageView, imageString: Int) {
        Glide.with(imageView)
            .asBitmap()
            .load(imageString)
            .centerCrop()
            .into(imageView)


        

    }






}