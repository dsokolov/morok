package me.ilich.morok

import me.ilich.morok.engine.Scene
import me.ilich.morok.system.InventoryShowScene
import me.ilich.morok.system.PromptExitScene
import me.ilich.morok.system.SelectModuleScene
import java.util.*

class InMemoryDataSource : DataSource {

    private val scenes = LinkedList<Scene>()
    private val generalScenes = listOf(
            PromptExitScene(),
            InventoryShowScene(),
            SelectModuleScene()
    )

    override fun clear() {
        scenes.clear()
    }

    override fun sceneAdd(scene: Scene) {
        scenes.add(scene)
    }

    override fun sceneById(id: String): Scene =
            (scenes + generalScenes).find { it.id == id }
                    ?:
                    throw RuntimeException("scene id=$id not found")

}