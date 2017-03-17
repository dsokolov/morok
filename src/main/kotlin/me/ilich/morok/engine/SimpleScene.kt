package me.ilich.morok.engine

import me.ilich.morok.App
import me.ilich.morok.Controllable
import me.ilich.morok.system.EchoAction

class SimpleScene(
        override val id: String,
        val title: String,
        val description: List<String>,
        override val availableCommands: AvailableCommands,
        override val commands: List<Command>,
        override val itemIds: List<String>
) : Scene() {

    override fun render(controllable: Controllable, renderMode: App.RenderMode) {
        if (renderMode == App.RenderMode.FULL) {
            println("** ${title} ** ")
            description.forEach(::println)
            itemIds.forEach { itemId ->
                val item = controllable.dataSource().itemById(itemId)
                println(item.title)
            }
            commands.forEach { command ->
                println("\t${command.key} ${command.title}")
            }
        }
    }

    override fun allCommands(controllable: Controllable): List<Command> {
        val l = super.allCommands(controllable)
        if (itemIds.isEmpty()) {
            return l
        } else {
            return l + itemIds.map { controllable.dataSource().itemById(it) }.
                    map { Command(it.title, it.title, listOf(EchoAction(it.description))) }
        }
    }

}