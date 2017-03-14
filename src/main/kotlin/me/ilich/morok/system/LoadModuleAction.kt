package me.ilich.morok.system

import me.ilich.morok.Controllable
import me.ilich.morok.engine.Action
import me.ilich.morok.engine.Item
import me.ilich.morok.engine.Scene
import me.ilich.morok.parser.Parser
import java.io.File
import java.util.*

class LoadModuleAction(val moduleFile: File) : Action() {

    override fun execute(controllable: Controllable) {
        val includes = LinkedList<File>()
        val parentDir = moduleFile.parentFile
        val dataSource = controllable.dataSource()
        dataSource.clear()
        var sceneId: String? = null
        val listener = object : Parser.Listener {

            override fun onStartSceneId(startSceneId: String) {
                sceneId = startSceneId
            }

            override fun onInclude(moduleFileName: String) {
                includes.add(File(parentDir, moduleFileName))
            }

            override fun onScene(scene: Scene) {
                dataSource.sceneAdd(scene)
            }

            override fun onItem(item: Item) {
                //TODO
            }
        }
        includes.add(moduleFile)
        while (includes.isNotEmpty()) {
            val fn = includes.first
            Parser.parse(fn, listener)
            includes.remove(fn)
        }
        sceneId?.let {
            controllable.reload(it)
        }
    }

}