package me.ilich.morok.module

import me.ilich.morok.scene.SelectModuleScene

class SystemModule : Module(
        title = "MorokEngine",
        startSceneId = "system_select_module",
        scenes = listOf(SelectModuleScene())
)