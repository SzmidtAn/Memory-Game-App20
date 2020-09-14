package com.example.lektion2

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.home_activity.*
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.home_activity.questButton as questButton1
import kotlinx.android.synthetic.main.home_fragment.quickGamebutton as quickGamebutton1

class HomeActivity : AppCompatActivity() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)


        questButton.setOnClickListener{
            val mIntent = Intent(this, QuestActivity::class.java)
            startActivity(mIntent)
        }

        quickGamebutton.setOnClickListener {
            showDialog(this)
        }


    }



}

private fun showDialog(context: Context) {
    val builder = AlertDialog.Builder(context)
    builder.setMessage("\n" + context.getString(R.string.message_rules) + "\n\n" +context.getString(R.string.rules2))
    builder.setTitle(context.getString(R.string.start))
    builder.setIcon(R.mipmap.fruit)
    builder.setCancelable(false)
    builder.setView(R.layout.dialog_vin)
    builder.setCancelable(true)
    builder.setNegativeButton(context.getString(R.string.cancel)){ dialogInterface, i ->

    }
    builder.setPositiveButton(context.getString(R.string.start_gam)) { dialogInterface, i ->
        gamesPoints=0
        val mIntent = Intent(context, PlayActivity::class.java)
        context.startActivity(mIntent)
    }
    builder.create().show()


}
