package me.ilich.morok

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.InputStreamReader

object App : Controllable {

    private val generalConnamds = listOf(
            ExitCommand
    )
    private var working = true
    private var sceneId: String? = null

    @JvmStatic fun main(vararg arg: String) {
        val parser: Gson = GsonBuilder().
                registerTypeAdapter(Action::class.java, ActionDeserializer()).
                create()
        val file = File("scripts/demo1/main.json")
        val reader = BufferedReader(FileReader(file))
        val setting = parser.fromJson(reader, Setting::class.java)
        reader.close()
        val userInput = BufferedReader(InputStreamReader(System.`in`))
        println("BEGIN")
        println("*** ${setting.title} ***")
        println()
        sceneId = setting.startSceneId
        while (working) {
            val scene = setting.scenes.findLast { it.id == sceneId }
            if (scene == null) {
                println("Scene $sceneId not found!")
                working = false
            } else {
                println("** ${scene.title} ** ")
                scene.description.forEach(::println)
                scene.commands.forEach { command ->
                    println("\t${command.key} ${command.title}")
                }
                val input = userInput.readLine()
                val suitableCommands = (scene.commands + generalConnamds).filter { command -> command.key.startsWith(input, true) }
                when (suitableCommands.size) {
                    0 -> println("Что такое '$input'?")
                    1 -> {
                        suitableCommands[0].actions?.forEach { action -> action.execute(this) }
                    }
                    else -> println("Несколько вариантов TODO")
                }
            }
            println()
        }
        println("END")
    }

    override fun setSceneId(sceneId: String) {
        this.sceneId = sceneId
    }

    override fun stop() {
        working = false
    }

    override fun echo(text: String) {
        println(text)
    }

}