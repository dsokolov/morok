package me.ilich.morok.action

import me.ilich.morok.Controllable

class ExitAction : Action("exit") {
    override fun execute(controllable: Controllable) {
        controllable.stop()
    }
}