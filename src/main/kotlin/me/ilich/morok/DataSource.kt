package me.ilich.morok

import me.ilich.morok.engine.Scene

interface DataSource {

    fun clear()
    fun sceneAdd(scene: Scene)
    fun sceneById(id: String): Scene

}