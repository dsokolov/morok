package me.ilich.morok.system

import me.ilich.morok.engine.Module
import me.ilich.morok.system.PromptExitScene
import me.ilich.morok.system.SelectModuleScene

class SystemModule : Module(
        title = "MorokEngine",
        startSceneId = "system_select_module",
        scenes = listOf(
                SelectModuleScene(),
                PromptExitScene()
        )
)