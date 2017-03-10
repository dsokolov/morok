package me.ilich.morok.system

import me.ilich.morok.Controllable
import me.ilich.morok.engine.Action

class GotoAction(val sceneId: String) : Action() {

    override fun execute(controllable: Controllable) {
        controllable.sceneGoto(sceneId)
    }

}