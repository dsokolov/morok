package me.ilich.morok.world

import me.ilich.morok.Engine

abstract class Room {
    abstract fun preview(): String
    abstract fun description(engine: Engine): String
}

