package me.ilich.morok

import me.ilich.morok.command.ExitCommand
import me.ilich.morok.command.HelpCommand
import me.ilich.morok.module.Module
import me.ilich.morok.module.SystemModule
import me.ilich.morok.scene.Scene
import java.io.BufferedReader
import java.io.InputStreamReader

object App : Controllable {

    private val generalCommamds = listOf(
            ExitCommand(),
            HelpCommand()
    )
    private var working = true
    private var renderSceneTitle = true
    private var renderSceneDescription = true
    private var renderSceneCommands = true
    private var currentModule: Module = SystemModule()
    private var currentSceneId: String = currentModule.startSceneId

    @JvmStatic fun main(vararg arg: String) {
        println("START ver 0.1")

        val userInput = BufferedReader(InputStreamReader(System.`in`))
        println()
        while (working) {
            val scene = currentModule.scenes.find { scene -> scene.id == currentSceneId }
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
            val suitableCommands = (scene.commands + generalCommamds).filter { command -> command.key.startsWith(userInput, true) }
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
        currentSceneId = module.startSceneId
        renderSceneTitle = true
        renderSceneDescription = true
        renderSceneCommands = true
    }

    override fun setSceneId(sceneId: String) {
        currentSceneId = sceneId
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