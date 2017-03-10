package me.ilich.morok.engine

open class Scene(
        val id: String,
        val title: String,
        val description: List<String>,
        val commands: List<Command>,
        val availableCommands: AvailableCommands = Scene.AvailableCommands.ALL
) {

    enum class AvailableCommands {
        ALL,
        ONLY_DECLARED
    }

}