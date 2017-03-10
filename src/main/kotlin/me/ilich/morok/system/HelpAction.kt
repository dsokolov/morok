package me.ilich.morok.system

import me.ilich.morok.Controllable
import me.ilich.morok.engine.Action

class HelpAction : Action() {

    override fun execute(controllable: Controllable) {
        controllable.echo("Команды")
        controllable.echo("СПРАВКА - это сообщение")
        controllable.echo("ВЫХОД - выйти из игры")
    }

}