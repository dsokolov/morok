package me.ilich.morok.command

import me.ilich.morok.action.Action

open class Command(
        val key: String,
        val title: String,
        val actions: List<Action>?
)