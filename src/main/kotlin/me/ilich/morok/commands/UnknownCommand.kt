package me.ilich.morok.commands

import me.ilich.morok.Engine
import me.ilich.morok.Input
import me.ilich.morok.Output

class UnknownCommand : Command() {
    override fun execute(engine: Engine, input: Input): Output {
        return Output("i don't know how to ${input.text}")
    }
}

