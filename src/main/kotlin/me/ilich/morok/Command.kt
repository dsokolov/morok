package me.ilich.morok

open class Command(
        val key: String,
        val title: String,
        val actions: List<Action>?
)