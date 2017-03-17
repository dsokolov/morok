package me.ilich.morok.system

import me.ilich.morok.App
import me.ilich.morok.Controllable
import me.ilich.morok.engine.Command
import me.ilich.morok.engine.Scene

class PromptExitScene : Scene() {

    companion object {
        const val ID = "system_prompt_exit"
    }

    override val id = ID
    override val commands = listOf(YesCommand(), NoCommand())
    override val availableCommands = AvailableCommands.ONLY_DECLARED
    override val itemIds = emptyList<String>()

    override fun render(controllable: Controllable, renderMode: App.RenderMode) {
        println("Вы действительно хотите выйти? (да/нет)")
    }

    class YesCommand : Command(
            key = "ДА",
            title = "да",
            actions = listOf(StopGameAction())
    )

    class NoCommand : Command(
            key = "НЕТ",
            title = "нет",
            actions = listOf(ReturnAction())
    )

}