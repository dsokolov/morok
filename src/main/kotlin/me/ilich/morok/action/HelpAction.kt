package me.ilich.morok.action

import me.ilich.morok.Controllable

class HelpAction : Action(
        type = "help"
) {
    override fun execute(controllable: Controllable) {
        controllable.echo("Команды")
        controllable.echo("СПРАВКА - это сообщение")
        controllable.echo("ВЫХОД - выйти из игры")
    }
}