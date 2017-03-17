package me.ilich.morok

import me.ilich.morok.engine.Item

interface Controllable {

    fun sceneGoto(sceneId: String)
    fun sceneGosub(sceneId: String)
    fun sceneReturn()
    fun stop()
    fun echo(text: String)
    fun dataSource(): DataSource
    fun reload(sceneId: String)
    fun inventory(): List<Item>

}