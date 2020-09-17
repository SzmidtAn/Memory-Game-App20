package com.example.lektion2

import com.example.lektion2.R.mipmap

fun getListOfElements(): MutableList<Element>{


    val listOfNames= mutableListOf<Element>()

    listOfNames.add(Element(R.drawable.appl, (0..9999).random()))
    listOfNames.add(Element(R.drawable.asparagus, (0..9999).random()))
    listOfNames.add(Element(R.drawable.aubergine, (0..9999).random()))
    listOfNames.add(Element(R.drawable.avocado, (0..9999).random()))
    listOfNames.add(Element(R.drawable.bacon, (0..9999).random()))
    listOfNames.add(Element(R.drawable.baguette, (0..9999).random()))
    listOfNames.add(Element(R.drawable.banana, (0..9999).random()))
    listOfNames.add(Element(R.drawable.beans, (0..9999).random()))
    listOfNames.add(Element(R.drawable.biscuit, (0..9999).random()))
    listOfNames.add(Element(R.drawable.blueberries, (0..9999).random()))
    listOfNames.add(Element(R.drawable.boiled, (0..9999).random()))
    listOfNames.add(Element(R.drawable.bowl, (0..9999).random()))
    listOfNames.add(Element(R.drawable.bread, (0..9999).random()))
    listOfNames.add(Element(R.drawable.broccoli, (0..9999).random()))
    listOfNames.add(Element(R.drawable.butcher, (0..9999).random()))
    listOfNames.add(Element(R.drawable.cabbage, (0..9999).random()))
    listOfNames.add(Element(R.drawable.cabbage, (0..9999).random()))
    listOfNames.add(Element(R.drawable.can, (0..9999).random()))
    listOfNames.add(Element(R.drawable.candy, (0..9999).random()))
    listOfNames.add(Element(R.drawable.carrot, (0..9999).random()))
    listOfNames.add(Element(R.drawable.cauliflower, (0..9999).random()))
    listOfNames.add(Element(R.drawable.cereals, (0..9999).random()))
    listOfNames.add(Element(R.drawable.chili, (0..9999).random()))
    listOfNames.add(Element(R.drawable.chips, (0..9999).random()))
    listOfNames.add(Element(R.drawable.cupcake, (0..9999).random()))
    listOfNames.add(Element(R.drawable.cutlery, (0..9999).random()))
    listOfNames.add(Element(R.drawable.cucumber, (0..9999).random()))
    listOfNames.add(Element(R.drawable.croissant, (0..9999).random()))
    listOfNames.add(Element(R.drawable.corn, (0..9999).random()))
    listOfNames.add(Element(R.drawable.corckscrew, (0..9999).random()))
    listOfNames.add(Element(R.drawable.cookies, (0..9999).random()))
    listOfNames.add(Element(R.drawable.coffee, (0..9999).random()))
    listOfNames.add(Element(R.drawable.coconut, (0..9999).random()))
    listOfNames.add(Element(R.drawable.chocolate, (0..9999).random()))
    listOfNames.add(Element(R.drawable.chives, (0..9999).random()))



    return listOfNames


}
