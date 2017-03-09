package me.ilich.morok.action

import me.ilich.morok.Controllable
import me.ilich.morok.Parser
import java.io.File

class LoadModuleAction(val module: File) : Action(
        type = "load_module"
) {
    override fun execute(controllable: Controllable) {
        val module = Parser.parse(module)
        controllable.setModule(module)
    }

}