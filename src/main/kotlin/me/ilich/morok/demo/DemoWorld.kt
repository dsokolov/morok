package me.ilich.morok.demo

import me.ilich.morok.world.Room
import me.ilich.morok.world.Transition
import me.ilich.morok.world.World
import me.ilich.morok.demo.ClockRoom
import me.ilich.morok.demo.NorthRoom
import me.ilich.morok.demo.SouthRoom

class DemoWorld : World {

    companion object {
        private val rooms = mapOf(
                "Clock" to ::ClockRoom,
                "N" to ::NorthRoom,
                "S" to ::SouthRoom
        )
        private const val startRoom = "Clock"
    }

    private var currentRoomId = startRoom

    override fun currentRoomId(): String = currentRoomId

    override fun roomById(id: String): Room =
            rooms.getOrElse(id) { ::VoidRoom }.invoke()

}