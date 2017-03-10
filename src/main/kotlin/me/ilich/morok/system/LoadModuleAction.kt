package me.ilich.morok.system

import me.ilich.morok.Controllable
import me.ilich.morok.engine.Action
import me.ilich.morok.engine.Item
import me.ilich.morok.engine.Module
import me.ilich.morok.engine.Scene
import me.ilich.morok.parser.Parser
import java.io.File

class LoadModuleAction(val moduleFile: File) : Action() {

    override fun execute(controllable: Controllable) {
        val mainModule = Parser.parse(moduleFile)
        val parentDir = moduleFile.parentFile
        val includeModules = mainModule.include.map { moduleFileName ->
            val includeModuleFile = File(parentDir, moduleFileName)
            Parser.parse(includeModuleFile)
        }
        val scenes = mutableListOf<Scene>()
        scenes.addAll(mainModule.scenes)
        includeModules.forEach { module ->
            scenes.addAll(module.scenes)
        }
        val items = includeModules.fold(emptyList<Item>()) { total, current ->
            total + current.items
        }
        val resultModule = Module(
                title = mainModule.title,
                startSceneId = mainModule.startSceneId,
                scenes = scenes,
                items = items,
                include = emptyList()
        )
        controllable.setModule(resultModule)
    }

}