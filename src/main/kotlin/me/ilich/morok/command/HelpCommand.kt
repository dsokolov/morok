package me.ilich.morok.command

import me.ilich.morok.action.HelpAction

class HelpCommand : Command(
        "СПРАВКА",
        "Справка",
        listOf(HelpAction())
)