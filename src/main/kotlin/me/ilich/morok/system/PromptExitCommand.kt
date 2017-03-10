package me.ilich.morok.system

import me.ilich.morok.engine.Command

class PromptExitCommand : Command(
        key = "ВЫХОД",
        title = "Выход",
        actions = listOf(GosubAction(PromptExitScene.ID))
)