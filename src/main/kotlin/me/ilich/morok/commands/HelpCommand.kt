package me.ilich.morok.commands

import me.ilich.morok.Engine
import me.ilich.morok.Input
import me.ilich.morok.Output

class HelpCommand : Command() {
    override fun execute(engine: Engine, input: Input): Output {
        val s = "*** Help ***\n" +
                "N,E,S,W - move north, east, south, west accordingly\n" +
                "LOOK - take a look around\n" +
                "WAIT - wait for a while\n" +
                "HELP - this text\n" +
                "QUIT - leave the game\n" +
                "All commands are case insensitive.\n"
        return Output(s)
    }
}

