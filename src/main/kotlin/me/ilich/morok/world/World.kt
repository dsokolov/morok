package me.ilich.morok.world

import me.ilich.morok.world.rooms.ClockRoom
import me.ilich.morok.world.rooms.NorthRoom
import me.ilich.morok.world.rooms.SouthRoom

class World {

    private val locations = listOf(
            ClockRoom(),
            NorthRoom(),
            SouthRoom()
    )

    private val transitions = listOf(
            Transition(locations[0], locations[1])
    )

}