package me.ilich.morok

import me.ilich.morok.engine.Module
import me.ilich.morok.engine.Scene
import me.ilich.morok.system.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object App : Controllable {

    private val generalCommands = listOf(
            PromptExitCommand(),
            HelpCommand(),
            InventoryCommand()
    )
    private val generalScenes = listOf(
            PromptExitScene(),
            InventoryShowScene()
    )
    private var working = true
    private var renderSceneTitle = true
    private var renderSceneDescription = true
    private var renderSceneCommands = true
    private lateinit var currentModule: Module
    private val sceneIdStack = Stack<String>()

    @JvmStatic fun main(vararg arg: String) {
        println("START ver 0.1")
        setModule(SystemModule())
        val userInput = BufferedReader(InputStreamReader(System.`in`))
        println()
        while (working) {
            val currentSceneId = sceneIdStack.peek()
            val allScenes = generalScenes + currentModule.scenes
            val scene = allScenes.find { scene -> scene.id == currentSceneId }
            if (scene == null) {
                println("Scene $currentSceneId not found.")
                working = false
            } else {
                renderScene(scene)
                val input = userInput.readLine()
                processUserInput(scene, input)
                println()
            }
        }

        println("FINISH")
    }

    private fun renderScene(scene: Scene) {
        if (renderSceneTitle) {
            println("** ${scene.title} ** ")
            renderSceneTitle = false
        }
        if (renderSceneDescription) {
            scene.description.forEach(::println)
            renderSceneDescription = false
        }
        if (renderSceneCommands) {
            scene.commands.forEach { command ->
                println("\t${command.key} ${command.title}")
            }
            renderSceneCommands = false
        }
    }

    private fun processUserInput(scene: Scene, input: String) {
        val userInput = input.trim()
        if (userInput.isBlank()) {
            println()
        } else {
            val sceneCommands = when (scene.availableCommands) {
                Scene.AvailableCommands.ALL -> (scene.commands + generalCommands)
                Scene.AvailableCommands.ONLY_DECLARED -> scene.commands
            }
            val suitableCommands = sceneCommands.filter { command -> command.key.startsWith(userInput, true) }
            when (suitableCommands.size) {
                0 -> println("Что такое '$input'?")
                1 -> {
                    suitableCommands[0].actions?.forEach { action -> action.execute(this) }
                }
                else -> println("Несколько вариантов TODO")
            }
        }
    }

    override fun setModule(module: Module) {
        currentModule = module
        sceneIdStack.clear()
        sceneIdStack.push(currentModule.startSceneId)
        renderSceneTitle = true
        renderSceneDescription = true
        renderSceneCommands = true
    }

    override fun sceneGoto(sceneId: String) {
        sceneIdStack.pop()
        sceneIdStack.push(sceneId)
        renderSceneTitle = true
        renderSceneDescription = true
        renderSceneCommands = true
    }

    override fun sceneGosub(sceneId: String) {
        sceneIdStack.push(sceneId)
        renderSceneTitle = true
        renderSceneDescription = true
        renderSceneCommands = true
    }

    override fun sceneReturn() {
        sceneIdStack.pop()
        renderSceneTitle = true
        renderSceneDescription = true
        renderSceneCommands = true
    }

    override fun stop() {
        working = false
    }

    override fun echo(text: String) {
        println(text)
    }

}