package me.ilich.morok.action

import me.ilich.morok.Controllable

class EchoAction(val text: List<String>) : Action("echo") {

    override fun execute(controllable: Controllable) {
        text.forEach { controllable.echo(it) }
    }

}