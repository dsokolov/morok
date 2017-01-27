package me.ilich.morok2.demo

import me.ilich.morok2.Command

class HelpCommand : Command() {

    override val aliases: List<String> = listOf(
            "СПРАВКА",
            "HELP",
            "?"
    )

}