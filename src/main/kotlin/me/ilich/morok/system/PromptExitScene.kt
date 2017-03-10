package me.ilich.morok.system

import me.ilich.morok.system.ReturnAction
import me.ilich.morok.engine.Command
import me.ilich.morok.engine.Scene

class PromptExitScene : Scene(
        id = ID,
        title = "Выйти?",
        commands = listOf(
                YesCommand(),
                NoCommand()
        ),
        description = listOf(
                "Вы действительно хотите выйти?"
        ),
        availableCommands = AvailableCommands.ONLY_DECLARED
) {

    companion object {
        const val ID = "system_prompt_exit"
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