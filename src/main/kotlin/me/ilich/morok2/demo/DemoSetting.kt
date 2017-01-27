package me.ilich.morok2.demo

import me.ilich.morok2.Scene
import me.ilich.morok2.Setting

class DemoSetting : Setting {

    private var working: Boolean = true
    private var scene: Scene = HelloScene()

    override fun processInput(input: String, currentScene: Scene) {
        val partsOriginal = input.split(" ")
        val parts = input.toUpperCase().split(" ").map(String::trim)
        if (parts.isEmpty()) {
            scene = EmptyScene()
        } else {
            val cmd = parts[0]
            val cmdOriginal = partsOriginal[0]
            val suitableCommands = scene.suitableCommands(cmd)
            if (suitableCommands.isEmpty()) {
                //TODO сказать что не знаю как выполнить
                println("Что такое '$cmdOriginal'?")
            } else if (suitableCommands.size == 1) {
                val command = suitableCommands[0]
                println("Выполняем $command")
                command.execute(this)
            } else {
                //TODO возможные варианты
                println("Возможно, вы имели ввиду: ")
                suitableCommands.forEach { command ->
                    val aliases = command.findAlias(cmd)
                    if (aliases.isNotEmpty()) {
                        val alias = aliases[0]
                        println("\t* $alias")
                    }
                }
            }
        }
    }

    override fun hasNextScene(): Boolean = working

    override fun nextScene(): Scene = scene

    override fun stop() {
        working = false
    }

}