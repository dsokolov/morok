package me.ilich.morok.commands

import me.ilich.morok.Engine
import me.ilich.morok.Input
import me.ilich.morok.Output

class StagnateCommand : Command(){
    override fun execute(engine: Engine, input: Input): Output {
        return Output("You are stagnating. Nothing useful.")
    }

}