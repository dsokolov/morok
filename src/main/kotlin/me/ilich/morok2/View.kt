package me.ilich.morok2

class View {

    private val sb = StringBuilder()

    fun println(s: String) {
        sb.appendln(s)
    }

    fun render() = sb.toString()

}