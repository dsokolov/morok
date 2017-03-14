package me.ilich.morok

interface Controllable {

    fun sceneGoto(sceneId: String)
    fun sceneGosub(sceneId: String)
    fun sceneReturn()
    fun stop()
    fun echo(text: String)
    fun dataSource(): DataSource
    fun reload(sceneId: String)

}