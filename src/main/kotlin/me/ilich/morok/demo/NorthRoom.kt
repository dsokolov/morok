package me.ilich.morok.demo

import me.ilich.morok.Engine
import me.ilich.morok.world.Room

class NorthRoom : Room() {

    override fun preview(): String = "North room"

    override fun description(engine: Engine): String =
            "You are stanging in North room. It's cold and dark here."

}