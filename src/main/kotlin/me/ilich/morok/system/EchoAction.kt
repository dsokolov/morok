package me.ilich.morok.system

import me.ilich.morok.Controllable
import me.ilich.morok.engine.Action

class EchoAction(val text: List<String>) : Action() {

    override fun execute(controllable: Controllable) {
        text.forEach { controllable.echo(it) }
    }

}