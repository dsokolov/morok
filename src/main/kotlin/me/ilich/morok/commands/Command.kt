package me.ilich.morok.commands

import me.ilich.morok.Engine
import me.ilich.morok.Input
import me.ilich.morok.Output

abstract class Command {

    companion object {

        fun create(engine: Engine, input: Input): Command {
            val parts = input.text.
                    toUpperCase().
                    split(delimiters = " ", ignoreCase = true).
                    filter(String::isNotBlank)
            val result = if (parts.isEmpty()) {
                EmptyCommand()
            } else if (parts.size == 1) {
                val commandBody = parts[0]
                when (commandBody) {
                    "QUIT" -> QuitCommand()
                    "HELP", "?" -> HelpCommand()
                    "WAIT" -> WaitCommand()
                    "LOOK" -> LookAroundCommand()
                    "WALK", "MOVE" -> StagnateCommand()
                    "N" -> MoveCommand(0, 1)
                    "S" -> MoveCommand(0, -1)
                    "E" -> MoveCommand(1, 0)
                    "W" -> MoveCommand(-1, 0)
                    else -> UnknownCommand()
                }
            } else {
                UnknownCommand()
            }
            return result
        }
    }

    abstract fun execute(engine: Engine, input: Input): Output

}

