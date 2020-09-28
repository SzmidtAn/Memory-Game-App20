package com.example.lektion2

import android.media.MediaPlayer
import android.widget.ImageView
import com.bumptech.glide.GenericTransitionOptions
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.FitCenter


class Element (var imageString: Int, var elementId:Int, var ifFind:Boolean = false,  val imageDefault: Int = R.drawable.question) {


    fun turnCard(imageView: ImageView, imageString: Int) {



        Glide.with(imageView)
            .asBitmap()
            .fitCenter()
            .load(imageString)
            .into(imageView)

    }






}