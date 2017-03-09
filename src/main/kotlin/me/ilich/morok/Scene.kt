package me.ilich.morok

data class Scene(
        val id: String,
        val title: String,
        val description: List<String>,
        val commands: List<Command>
)