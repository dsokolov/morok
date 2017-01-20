package me.ilich.morok.world.rooms

import me.ilich.morok.Engine
import me.ilich.morok.world.Room

class NorthRoom : Room() {

    override fun title(): String = "North room"

    override fun description(engine: Engine): String =
            "You are stanging in North room. It's cold and dark here."

}