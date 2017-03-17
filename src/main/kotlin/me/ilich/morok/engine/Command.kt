package me.ilich.morok.engine

import me.ilich.morok.Controllable

open class Command(
        val key: String,
        val title: String,
        val actions: List<Action>?
) {

    fun execute(controllable: Controllable) {
        actions?.forEach { action ->
            action.execute(controllable)
        }
    }

    override fun toString(): String {
        return "{Command key=$key actions=$actions}"
    }

}