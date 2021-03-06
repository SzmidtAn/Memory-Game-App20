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
import kotlinx.android.synthetic.main.dialog_memory_rules.view.*


open class DialogFragmentMemoryRules(numOfCards: Int = 12, numOfSpan: Int= 3) : DialogFragment() {

    var numOfCards=numOfCards
        var numOfSpan=numOfSpan


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        getDialog()!!.getWindow()?.setBackgroundDrawableResource(R.drawable.empty);
        return inflater.inflate(R.layout.dialog_memory_rules, container, false)


    }

    @SuppressLint("ResourceAsColor")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {



        val v = activity!!.layoutInflater
            .inflate(R.layout.dialog_memory_rules, null)

        v.setOnClickListener {

            context?.let { it1 -> startGame(it1, numOfCards, numOfSpan) }
        }


        return AlertDialog.Builder(activity)
            .setView(v)
            .create()


    }






}