package me.ilich.morok.system

import me.ilich.morok.Controllable
import me.ilich.morok.engine.Action

class GosubAction(val sceneId: String) : Action() {

    override fun execute(controllable: Controllable) {
        controllable.sceneGosub(sceneId)
    }

}