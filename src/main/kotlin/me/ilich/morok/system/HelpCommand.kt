package me.ilich.morok.system

import me.ilich.morok.system.HelpAction
import me.ilich.morok.engine.Command

class HelpCommand : Command(
        "СПРАВКА",
        "Справка",
        listOf(HelpAction())
)