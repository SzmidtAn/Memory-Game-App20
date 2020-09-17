package com.example.lektion2

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_memory_rules.view.*


open class DialogFragmentMemoryRules(numOfCards: Int = 12, numOfSpan: Int= 3) : DialogFragment() {

    var numOfCards=numOfCards
        var numOfSpan=numOfSpan


    @SuppressLint("ResourceAsColor")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {



        val v = activity!!.layoutInflater
            .inflate(R.layout.dialog_memory_rules, null)

        v.cancelImageButton.setOnClickListener {
            movesInGame=0

            val mIntent = Intent(context, PlayActivity::class.java)
            mIntent.putExtra("ww", numOfCards)
            mIntent.putExtra("rr", numOfSpan)
            context!!.startActivity(mIntent)
        }

        return AlertDialog.Builder(activity)
            .setView(v)
            .create()


    }








}