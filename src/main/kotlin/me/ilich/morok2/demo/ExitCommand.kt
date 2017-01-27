package me.ilich.morok2.demo

import me.ilich.morok2.Command
import me.ilich.morok2.Setting

class ExitCommand() : Command() {

    override val aliases: List<String> = listOf(
            "ВЫХОД",
            "QUIT",
            "EXIT"
    )

    override fun execute(setting: Setting) {
        println("Всего хорошего.")
        setting.stop()
    }

}