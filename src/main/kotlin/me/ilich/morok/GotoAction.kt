package me.ilich.morok

class GotoAction(val sceneId: String) : Action("goto") {

    override fun execute(controllable: Controllable) {
        controllable.setSceneId(sceneId)
    }

}