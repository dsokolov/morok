package me.ilich.morok.world

class Scene {

    private val texts = StringBuilder()

    fun addText(text: String) {
        texts.append(text)
    }

    fun renderAsString(): String {
        return texts.toString()
    }

}