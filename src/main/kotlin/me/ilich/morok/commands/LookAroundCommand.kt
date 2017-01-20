package me.ilich.morok.commands

import me.ilich.morok.Engine
import me.ilich.morok.Input
import me.ilich.morok.Output
import me.ilich.morok.world.Direction

class LookAroundCommand : Command() {

    override fun execute(engine: Engine, input: Input): Output {
        val sb = StringBuilder()
        sb.append("You are looking around.\n")
        sb.append(engine.currentLocation().description(engine))
        sb.append("\n")
        engine.exits().forEach {
            val d = when (it.key) {
                Direction.N -> "N"
                Direction.NE -> "NE"
                Direction.E -> "E"
                Direction.ES -> "SE"
                Direction.S -> "S"
                Direction.SW -> "SW"
                Direction.W -> "W"
                Direction.NW -> "NW"
            }
            val title = it.value.title()
            sb.append("$d : $title\n")
        }
        return Output(sb.toString())
    }

}