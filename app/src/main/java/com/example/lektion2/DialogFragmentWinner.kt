package com.example.lektion2

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_winner.view.*


open class DialogFragmentWinner() : DialogFragment() {



    @SuppressLint("ResourceAsColor")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {


        var i= loadScore(context)

        val v = activity!!.layoutInflater
            .inflate(R.layout.dialog_winner, null)

        if (movesInGame == i!!.toInt()){

        v.movesTextView.text="New high score is " + movesInGame.toString()
        }else{
        v.movesTextView.text="Moves: " + movesInGame.toString() + "\nCurrently the best result is " + i
            v.TrophyimageView.visibility=View.GONE
            v.Trophy2imageView.visibility=View.GONE

        }



        v.timeDialogWinTextView.text= "Time: " + timeView!!.text.toString()

        v.goToMenuButton.setOnClickListener {
            val mIntent = Intent(context, HomeActivity::class.java)
            context!!.startActivity(mIntent)
        }

        v.goToNextLevelButton.setOnClickListener {
            val mIntent = Intent(context, QuestActivity::class.java)
            context!!.startActivity(mIntent)        }

        return AlertDialog.Builder(activity)
            .setView(v)
            .create()


    }








}