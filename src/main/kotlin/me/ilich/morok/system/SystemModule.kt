package me.ilich.morok.system

import me.ilich.morok.engine.Module

class SystemModule : Module(
        title = "MorokEngine",
        startSceneId = "system_select_module",
        scenes = listOf(
                SelectModuleScene(),
                PromptExitScene()
        )
)