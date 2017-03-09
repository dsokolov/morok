package me.ilich.morok

class EchoAction(val text: String) : Action("echo") {

    override fun execute(controllable: Controllable) {
        controllable.echo(text)
    }

}