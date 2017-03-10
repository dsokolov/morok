package me.ilich.morok.action

import me.ilich.morok.Controllable
import me.ilich.morok.Parser
import me.ilich.morok.module.Module
import me.ilich.morok.scene.Scene
import java.io.File

class LoadModuleAction(val moduleFile: File) : Action(
        type = "load_module"
) {
    override fun execute(controllable: Controllable) {
        val mainModule = Parser.parse(moduleFile)
        val parentDir = moduleFile.parentFile
        val includeModules = mainModule.include.map { moduleFileName ->
            val includeModuleFile = File(parentDir, moduleFileName)
            println(includeModuleFile.absoluteFile)
            Parser.parse(includeModuleFile)
        }
        val scenes = mutableListOf<Scene>()
        if(mainModule.scenes==null){
            throw NullPointerException()
        }
        scenes.addAll(mainModule.scenes)
        includeModules.forEach { module ->
            scenes.addAll(module.scenes)
        }
        val resultModule = Module(
                title = mainModule.title,
                startSceneId = mainModule.startSceneId,
                scenes = scenes,
                include = emptyList()
        )
        controllable.setModule(resultModule)
    }

}