package me.ilich.morok.scene

import me.ilich.morok.command.Command

open class Scene(
        val id: String,
        val title: String,
        val description: List<String>,
        val commands: List<Command>
)