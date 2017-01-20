package me.ilich.morok.commands

import me.ilich.morok.Engine
import me.ilich.morok.Input
import me.ilich.morok.Output

class WaitCommand : Command(){

    override fun execute(engine: Engine, input: Input): Output {
        engine.addTime(60 * 1000L)
        return Output("You waited a bit.")
    }

}