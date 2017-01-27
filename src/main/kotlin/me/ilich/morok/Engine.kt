package me.ilich.morok

import me.ilich.morok.commands.Command
import me.ilich.morok.world.*
import me.ilich.morok.demo.ClockRoom
import me.ilich.morok.demo.NorthRoom
import me.ilich.morok.demo.SouthRoom
import java.util.*
import javax.xml.stream.Location

class Engine(
        private val world: World
) {

    private var working = true
    private val locations = mapOf(
            Pos(0, 0) to ClockRoom(),
            Pair(0, 1) to NorthRoom(),
            Pair(0, -1) to SouthRoom()
    )
    private var currentTime = Date(1000L)
    private var playerPosition = Pair(0, 0)

    fun currentLocation(): Room =
            locations.getOrElse(playerPosition) {
                throw  RuntimeException()
            }

    fun canMove(x: Int, y: Int): Boolean {
        val p = Pair(playerPosition.first + x, playerPosition.second + y)
        return locations.containsKey(p)
    }

    fun moveBy(x: Int, y: Int) {
        val p = Pair(playerPosition.first + x, playerPosition.second + y)
        playerPosition = p
    }

    fun tick(input: Input): Output {
/*        val roomId = world.currentRoomId()
        val room = world.roomById(roomId)
        val roomDescription = room.description(this)*/
        val command = Command.create(this, input)
        val output = command.execute(this, input)
        return output
    }

    fun time() = currentTime

    fun addTime(i: Long) {
        currentTime = Date(currentTime.time + i)
    }

    fun exits(): Map<Direction, Room> {
        val map = mutableMapOf<Direction, Room>()
        for (d in Direction.values()) {
            val pos = Pair(playerPosition.first + d.pos().first, playerPosition.second + d.pos().second)
            locations.getOrElse(pos) {
                null
            }?.let {
                map.put(d, it)
            }
        }
        return map
    }

    fun isWorking() = working

    fun stop() {
        working = false
    }

}

