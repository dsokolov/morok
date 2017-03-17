package me.ilich.morok.system

import me.ilich.morok.App
import me.ilich.morok.Controllable
import me.ilich.morok.engine.Command
import me.ilich.morok.engine.Scene
import me.ilich.morok.parser.ModuleHeader
import me.ilich.morok.parser.Parser
import java.io.File

class SelectModuleScene : Scene() {

    companion object {

        const val ID = "system_select_module"

        fun commands(): List<Command> {
            val rootDir = File(System.getProperty("user.dir"))
            val files = rootDir.listFiles()
            val modules = files.
                    filter { file -> file.isFile && !file.isHidden && file.name.endsWith(".json", true) }.
                    mapIndexed { i, file ->
                        val index = i + 1
                        val fileName = file.name
                        var module: ModuleHeader? = null
                        try {
                            module = Parser.parseHeader(file)
                        } catch (e: Throwable) {
                            e.printStackTrace()
                        }
                        val title = "${module?.title} ($fileName)"
                        Command("$index", title, listOf(LoadModuleAction(file)))
                    }
            val result = modules + Command("0", "Выход", listOf(StopGameAction()))
            return result
        }
    }

    override val id = ID
    override val availableCommands = AvailableCommands.ONLY_DECLARED
    override val commands = commands()
    override val itemIds = emptyList<String>()

    override fun render(controllable: Controllable, renderMode: App.RenderMode) {
        println("Morok Engine")
        commands.forEach { command ->
            println("[${command.key}] ${command.title}")
        }
    }

}