package me.ilich.morok

abstract class Action(
        val type: String
) {

    abstract fun execute(controllable: Controllable)

}