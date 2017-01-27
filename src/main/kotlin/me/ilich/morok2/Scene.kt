package me.ilich.morok2

abstract class Scene {

    protected abstract val commands : List<Command>

    abstract fun render(view: View)

    fun suitableCommands(cmd: String) =
            commands.filter { it.startWith(cmd) }

}