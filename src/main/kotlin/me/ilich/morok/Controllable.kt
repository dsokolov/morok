package me.ilich.morok

import me.ilich.morok.engine.Module

interface Controllable {

    fun setModule(module: Module)
    fun sceneGoto(sceneId: String)
    fun sceneGosub(sceneId: String)
    fun sceneReturn()
    fun stop()
    fun echo(text: String)

}