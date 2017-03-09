package me.ilich.morok.action

import me.ilich.morok.Controllable

class GotoAction(val sceneId: String) : Action("goto") {

    override fun execute(controllable: Controllable) {
        controllable.setSceneId(sceneId)
    }

}