package me.ilich.morok

class ExitAction : Action("exit") {
    override fun execute(controllable: Controllable) {
        controllable.stop()
    }
}