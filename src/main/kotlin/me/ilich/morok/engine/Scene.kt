package me.ilich.morok.engine

import me.ilich.morok.App
import me.ilich.morok.Controllable
import me.ilich.morok.system.HelpCommand
import me.ilich.morok.system.InventoryCommand
import me.ilich.morok.system.PromptExitCommand

abstract class Scene {

    abstract val id: String
    abstract val commands: List<Command>
    abstract val availableCommands: AvailableCommands
    abstract val itemIds: List<String>

    companion object {
        val generalCommands = listOf(
                PromptExitCommand(),
                HelpCommand(),
                InventoryCommand()
        )
    }

    enum class AvailableCommands {
        ALL,
        ONLY_DECLARED
    }

    open fun render(controllable: Controllable, renderMode: App.RenderMode) {

    }

    open fun allCommands(controllable: Controllable): List<Command> =
            when (availableCommands) {
                AvailableCommands.ONLY_DECLARED -> commands
                AvailableCommands.ALL -> commands + generalCommands
            }

    open fun suitableCommands(controllable: Controllable, userInput: String): List<Command> =
            allCommands(controllable).
                    filter { command ->
                        command.key.startsWith(userInput, true)
                    }

    open fun processInput(controllable: Controllable, input: String, command: Command) {
        command.execute(controllable)
    }

    override fun toString(): String {
        return "{id=$id commands=$commands}"
    }

}