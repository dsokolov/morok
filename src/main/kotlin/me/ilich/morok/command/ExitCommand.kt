package me.ilich.morok.command

import me.ilich.morok.action.ExitAction
import me.ilich.morok.command.Command

class ExitCommand : Command(
        key = "ВЫХОД",
        title = "Выход",
        actions = listOf(ExitAction())
)