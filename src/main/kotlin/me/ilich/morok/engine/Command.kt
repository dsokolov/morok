package me.ilich.morok.engine

import me.ilich.morok.engine.Action

open class Command(
        val key: String,
        val title: String,
        val actions: List<Action>?
)