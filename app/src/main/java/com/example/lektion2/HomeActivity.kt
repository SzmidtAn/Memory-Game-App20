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


    override fun onBackPressed() {
    showDialog(this)
    }

}

private fun showDialog(context: Context) {
    val builder = AlertDialog.Builder(context)
    builder.setMessage("\nMASZ 3 SEKUNDY NA ZAPAMIĘTANIE WSZYSTKICH OBRAZKÓW" +
            "\n\nPOŁĄCZ OBRAZKI PARAMI I POBIJ REKORD!")
    builder.setTitle("ROZPOCZNIJ GRĘ")
    builder.setIcon(R.mipmap.fruit)
    builder.setCancelable(false)
    builder.setView(R.layout.dialog_vin)
    builder.setCancelable(true)
    builder.setNegativeButton("Anuluj"){dialogInterface, i ->

    }
    builder.setPositiveButton("Rozpocznij grę") { dialogInterface, i ->
        gamesPoints=0
        val mIntent = Intent(context, PlayActivity::class.java)
        context.startActivity(mIntent)
    }
    builder.create().show()


}
