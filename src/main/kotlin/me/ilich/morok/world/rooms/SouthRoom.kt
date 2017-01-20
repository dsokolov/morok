package me.ilich.morok.world.rooms

import me.ilich.morok.Engine
import me.ilich.morok.world.Room

class SouthRoom : Room() {
    override fun preview(): String = "South room"

    override fun description(engine: Engine): String =
            "This is South room. It's hot here like everywhere in south except Australia."
}