package com.example.lektion2

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class LevelRecyclerViewAdapter(private val myDataset: MutableList<Level>?) :
    RecyclerView.Adapter<LevelRecyclerViewAdapter.MyViewHolder>() {


    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view){

        var imageElement = view.findViewById<ImageView>(R.id.imageImageView)
        var levelText = view.findViewById<TextView>(R.id.levelTextView)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): LevelRecyclerViewAdapter.MyViewHolder {
        // create a new view
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.element_level_recycler_view, parent, false)
        // set the view's size, margins, paddings and layout parameters



        return MyViewHolder(textView)
    }



    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() : Int{

        return myDataset!!.size
    }


    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: LevelRecyclerViewAdapter.MyViewHolder, position: Int) {

      var level= myDataset!![position]

        var text: String= level.level.toString()
        holder.levelText.text=text


        if (text.toInt() > 20 ){
            holder.levelText.setBackgroundColor(R.color.colorPrimary)
            holder.levelText.setTextColor(R.color.colorPrimaryDark)
        }else{

        holder.levelText.setOnClickListener{
            level.cou()
            showDialog(holder.levelText.context, level.numberOfCards, level.numberOfSpan)

        }

        }

    }
}


private fun showDialog(context: Context, numOfCards:Int, numOfSpan: Int) {
    val builder = AlertDialog.Builder(context)
    builder.setMessage("\n" + context.getString(R.string.message_rules) + "\n\n" +context.getString(R.string.rules2))

    builder.setTitle(context.getString(R.string.start_gam))
    builder.setIcon(R.mipmap.fruit)
    builder.setCancelable(false)
    builder.setView(R.layout.dialog_vin)
    builder.setCancelable(true)
    builder.setNegativeButton(context.getString(R.string.cancel)){dialogInterface, i ->

    }
    builder.setPositiveButton(context.getString(R.string.start_gam)) { dialogInterface, i ->
        gamesPoints=0
        val mIntent = Intent(context, PlayActivity::class.java)
        mIntent.putExtra("ww", numOfCards)
        mIntent.putExtra("rr", numOfSpan)
        context.startActivity(mIntent)
    }
    builder.create().show()


}



fun changeCardsNumber(){

}
