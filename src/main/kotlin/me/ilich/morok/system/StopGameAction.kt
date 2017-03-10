package me.ilich.morok.system

import me.ilich.morok.Controllable
import me.ilich.morok.engine.Action

class StopGameAction : Action() {

    override fun execute(controllable: Controllable) {
        controllable.stop()
    }

}