package me.ilich.morok

interface Controllable {

    fun setSceneId(sceneId: String)
    fun stop()
    fun echo(text: String)

}