package com.example.lektion2

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class FireMissilesDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("grgwe4")
        builder.setMessage("gege")
        builder.setCancelable(false)
        builder.setNegativeButton("eff") { dialogInterface, i -> }
        return builder.create()
    }
}