package me.ilich.morok.action

import me.ilich.morok.Controllable

abstract class Action(
        val type: String
) {

    abstract fun execute(controllable: Controllable)

}