package me.ilich.morok2

abstract class Command {

    protected abstract val aliases: List<String>

    fun startWith(cmd: String): Boolean =
            aliases.count { it.startsWith(cmd, true) } != 0

    fun findAlias(cmd: String): List<String> =
            aliases.filter { it.startsWith(cmd, true) }

    open fun execute(setting: Setting) {
        TODO()
    }

}