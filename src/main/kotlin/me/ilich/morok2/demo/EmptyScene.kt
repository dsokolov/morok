package me.ilich.morok2.demo

import me.ilich.morok2.Command
import me.ilich.morok2.Scene
import me.ilich.morok2.View

class EmptyScene : Scene() {

    override val commands: List<Command> = emptyList()

    override fun render(view: View) {

    }
}