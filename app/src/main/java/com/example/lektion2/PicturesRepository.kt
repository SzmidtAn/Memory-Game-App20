package com.example.lektion2

import com.example.lektion2.R.mipmap

fun getListOfElements(): MutableList<Element>{


    val listOfNames= mutableListOf<Element>()

    listOfNames.add(Element(mipmap.appl, (0..9999).random()))
    listOfNames.add(Element(mipmap.asparagus, (0..9999).random()))
    listOfNames.add(Element(mipmap.aubergine, (0..9999).random()))
    listOfNames.add(Element(mipmap.avocado, (0..9999).random()))
    listOfNames.add(Element(mipmap.bacon, (0..9999).random()))
    listOfNames.add(Element(mipmap.baguette, (0..9999).random()))
    listOfNames.add(Element(mipmap.banana, (0..9999).random()))
    listOfNames.add(Element(mipmap.beans, (0..9999).random()))
    listOfNames.add(Element(mipmap.biscuit, (0..9999).random()))
    listOfNames.add(Element(mipmap.blueberries, (0..9999).random()))
    listOfNames.add(Element(mipmap.boiled, (0..9999).random()))
    listOfNames.add(Element(mipmap.bowl, (0..9999).random()))
    listOfNames.add(Element(mipmap.bread, (0..9999).random()))
    listOfNames.add(Element(mipmap.broccoli, (0..9999).random()))
    listOfNames.add(Element(mipmap.butcher, (0..9999).random()))
    listOfNames.add(Element(mipmap.cabbage, (0..9999).random()))
    listOfNames.add(Element(mipmap.cabbage, (0..9999).random()))
    listOfNames.add(Element(mipmap.can, (0..9999).random()))
    listOfNames.add(Element(mipmap.candy, (0..9999).random()))
    listOfNames.add(Element(mipmap.carrot, (0..9999).random()))
    listOfNames.add(Element(mipmap.cauliflower, (0..9999).random()))
    listOfNames.add(Element(mipmap.cereals, (0..9999).random()))
    listOfNames.add(Element(mipmap.chili, (0..9999).random()))
    listOfNames.add(Element(mipmap.chips, (0..9999).random()))
    listOfNames.add(Element(mipmap.cupcake, (0..9999).random()))
    listOfNames.add(Element(mipmap.cutlery, (0..9999).random()))
    listOfNames.add(Element(mipmap.cucumber, (0..9999).random()))
    listOfNames.add(Element(mipmap.croissant, (0..9999).random()))
    listOfNames.add(Element(mipmap.corn, (0..9999).random()))
    listOfNames.add(Element(mipmap.corckscrew, (0..9999).random()))
    listOfNames.add(Element(mipmap.cookies, (0..9999).random()))
    listOfNames.add(Element(mipmap.coffee, (0..9999).random()))
    listOfNames.add(Element(mipmap.coconut, (0..9999).random()))
    listOfNames.add(Element(mipmap.chocolate, (0..9999).random()))
    listOfNames.add(Element(mipmap.chives, (0..9999).random()))



    return listOfNames


}
