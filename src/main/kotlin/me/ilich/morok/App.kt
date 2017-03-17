package me.ilich.morok

import me.ilich.morok.engine.Item
import me.ilich.morok.engine.Scene
import me.ilich.morok.system.SelectModuleScene
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object App : Controllable {

    private val dataSource: DataSource = InMemoryDataSource()
    private var working = true
    private var renderMode: RenderMode = RenderMode.FULL
    private val sceneIdStack = Stack<String>()

    enum class RenderMode {
        FULL,
        SHORT,
        NONE
    }

    @JvmStatic fun main(vararg arg: String) {
        println("START ver 0.1")
        reload(SelectModuleScene.ID)
        val userInput = BufferedReader(InputStreamReader(System.`in`))
        println()
        while (working) {
            val currentSceneId = sceneIdStack.peek()
            val scene = dataSource.sceneById(currentSceneId)
            scene.render(this, renderMode)
            renderMode = RenderMode.NONE
            val input = userInput.readLine()
            processUserInput(scene, input)
        }
        println("FINISH")
    }

    private fun processUserInput(scene: Scene, input: String) {
        val userInput = input.trim()
        if (userInput.equals("debug", true) || userInput.equals("отладка", true)) {
            println("scene_id=${sceneIdStack.peek()}")
            println("scene=$scene")
        } else {
            if (userInput.isBlank()) {
                println("Что-что? :)")
            } else {
                val commands = scene.suitableCommands(this, userInput)
                when (commands.size) {
                    0 -> println("Что значит $userInput?")
                    1 -> scene.processInput(this, input, commands.first())
                    else -> println("Не понятно что такое $userInput. $commands")
                }
            }
        }
    }

    override fun reload(sceneId: String) {
        sceneIdStack.clear()
        sceneIdStack.push(sceneId)
        renderMode = RenderMode.FULL
    }

    override fun sceneGoto(sceneId: String) {
        sceneIdStack.pop()
        sceneIdStack.push(sceneId)
        renderMode = RenderMode.FULL
    }

    override fun sceneGosub(sceneId: String) {
        sceneIdStack.push(sceneId)
        renderMode = RenderMode.FULL
    }

    override fun sceneReturn() {
        sceneIdStack.pop()
        renderMode = RenderMode.FULL
    }

    override fun stop() {
        working = false
    }

    override fun echo(text: String) {
        println(text)
    }

    override fun dataSource(): DataSource = dataSource

    override fun inventory(): List<Item> {
        return emptyList()
    }

}