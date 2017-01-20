package me.ilich.morok.commands

import me.ilich.morok.Engine
import me.ilich.morok.Input
import me.ilich.morok.Output

class MoveCommand(val x: Int, val y: Int) : Command() {

    override fun execute(engine: Engine, input: Input): Output {
        if (engine.canMove(x, y)) {
            engine.moveBy(x, y)
            return Output("moving...")
        } else {
            return Output("you cant move there")
        }
    }

}

