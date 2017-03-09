package me.ilich.morok.scene

import me.ilich.morok.command.Command
import me.ilich.morok.Parser
import me.ilich.morok.action.ExitAction
import me.ilich.morok.action.LoadModuleAction
import me.ilich.morok.module.Module
import sun.security.pkcs11.Secmod
import java.io.File

class SelectModuleScene : Scene(
        id = "system_select_module",
        title = "MorokEngine 0.1",
        description = listOf("Разработка и отладка"),
        commands = commands()
) {

    companion object {
        fun commands(): List<Command> {
            val rootDir = File(System.getProperty("user.dir"))
            val files = rootDir.listFiles()
            val modules = files.mapIndexed { i, file ->
                val index = i + 1
                val fileName = file.name
                var module: Module? = null
                try {
                    module = Parser.parse(file)
                } catch (e: Throwable) {
                    e.printStackTrace()
                }
                val title = "${module?.title} ($fileName)"
                Command("$index", title, listOf(LoadModuleAction(file)))
            }
            val result = modules + Command("0", "Выход", listOf(ExitAction()))
            return result
        }
    }

}