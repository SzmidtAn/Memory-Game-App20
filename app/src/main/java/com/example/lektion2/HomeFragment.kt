package com.example.lektion2

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.home_activity.*
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.home_fragment, container,
            false)


        return view
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
        val mIntent = Intent(context, QuestActivity::class.java)
        context.startActivity(mIntent)
    }
    builder.create().show()


}

}
