package com.example.lektion2

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_winner.view.*


open class DialogFragmentWinner() : DialogFragment() {



    @SuppressLint("ResourceAsColor")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {



        val v = activity!!.layoutInflater
            .inflate(R.layout.dialog_winner, null)

        v.movesTextView.text="Moves: " + movesInGame.toString()
        v.timeDialogWinTextView.text= "Time: " + timeView!!.text.toString()

        v.goToMenuButton.setOnClickListener {
            val mIntent = Intent(context, HomeActivity::class.java)
            context!!.startActivity(mIntent)
        }

        return AlertDialog.Builder(activity)
            .setView(v)
            .create()


    }








}