package me.ilich.morok.world

import me.ilich.morok.Engine

abstract class Room {
    abstract fun title(): String
    abstract fun description(engine: Engine): String
}

