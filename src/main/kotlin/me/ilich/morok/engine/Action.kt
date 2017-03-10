package me.ilich.morok.engine

import me.ilich.morok.Controllable

abstract class Action {

    abstract fun execute(controllable: Controllable)

}