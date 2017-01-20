package me.ilich.morok.world.rooms

import me.ilich.morok.Engine
import me.ilich.morok.world.Room

class SimpleRoom(
        private val title: String,
        private val description: String
) : Room() {

    override fun title(): String = title

    override fun description(engine: Engine): String = description

}

