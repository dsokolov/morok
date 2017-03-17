package me.ilich.morok

import me.ilich.morok.engine.Item
import me.ilich.morok.engine.Scene

interface DataSource {

    fun clear()
    fun sceneAdd(scene: Scene)
    fun itemAdd(item: Item)
    fun sceneById(id: String): Scene
    fun itemById(id: String): Item

}