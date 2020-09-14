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
    builder.setMessage(context.getString(R.string.message_rules))
    builder.setTitle(context.getString(R.string.start_gam))
    builder.setIcon(R.mipmap.fruit)
    builder.setCancelable(false)
    builder.setView(R.layout.dialog_vin)
    builder.setCancelable(true)
    builder.setNegativeButton(context.getString(R.string.cancel)){dialogInterface, i ->

    }
    builder.setPositiveButton(context.getString(R.string.start_gam)) { dialogInterface, i ->
        gamesPoints=0
        val mIntent = Intent(context, QuestActivity::class.java)
        context.startActivity(mIntent)
    }
    builder.create().show()


}

}
