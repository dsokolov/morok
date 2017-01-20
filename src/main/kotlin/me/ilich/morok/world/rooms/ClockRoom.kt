package me.ilich.morok.world.rooms

import me.ilich.morok.Engine
import me.ilich.morok.world.Room
import java.text.SimpleDateFormat

class ClockRoom : Room() {

    val sdf = SimpleDateFormat("HH:mm")

    override fun preview(): String = "Clock room"

    override fun description(engine: Engine): String {
        val time = sdf.format(engine.time())
        val s = "You are standing in a wide bright room full of clocks. The biggest one is in front of you. It shows $time."
        return s
    }
}