package me.ilich.morok2.demo

import me.ilich.morok2.Command

class PlayCommand : Command() {

    override val aliases: List<String> = listOf(
            "ИГРАТЬ",
            "СТАРТ",
            "PLAY"
    )

}