package com.example.lektion2

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_winner.view.*


open class DialogFragmentWinner() : DialogFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        getDialog()!!.getWindow()?.setBackgroundDrawableResource(R.drawable.empty);
        return inflater.inflate(R.layout.dialog_winner, container, false)


    }


    @SuppressLint("ResourceAsColor")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {



        var v: View? = null

        var i= loadScore(context)


        if (movesInGame == i!!.toInt()){
             v = activity!!.layoutInflater
                .inflate(R.layout.dialog_winner_best_score, null)
            v.movesTextView.text= movesInGame.toString()
        }else{
            v = activity!!.layoutInflater
                .inflate(R.layout.dialog_winner, null)

            v.movesTextView.text=movesInGame.toString()

        }



        v.timeDialogWinTextView.text= timeView!!.text.toString()

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