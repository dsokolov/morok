package me.ilich.morok

import me.ilich.morok.module.Module

interface Controllable {

    fun setModule(module: Module)
    fun setSceneId(sceneId: String)
    fun stop()
    fun echo(text: String)

}