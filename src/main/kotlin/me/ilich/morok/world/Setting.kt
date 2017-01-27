package me.ilich.morok.world

import me.ilich.morok.demo.ClockRoom
import me.ilich.morok.demo.NorthRoom
import me.ilich.morok.demo.SouthRoom

object Setting {

    val rooms = mapOf(
            "Clock" to ::ClockRoom,
            "N" to ::NorthRoom,
            "S" to ::SouthRoom
    )

    val doors = mapOf(
            Direct("Clock", "N") to ::TransparentDoor,
            Direct("N", "Clock") to ::TransparentDoor
    )

    data class Id(val id: String)

    data class Direct(val source: String, val target: String)

}
