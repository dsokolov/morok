package me.ilich.morok.system

import me.ilich.morok.App
import me.ilich.morok.Controllable
import me.ilich.morok.engine.Command
import me.ilich.morok.engine.Scene

class InventoryShowScene : Scene() {

    companion object {
        const val ID = "system_inventory_show"
    }

    override val id = ID
    override val availableCommands = AvailableCommands.ONLY_DECLARED
    override val commands = listOf(Command("0", "назад", listOf(ReturnAction())))
    override val itemIds = emptyList<String>()

    override fun suitableCommands(controllable: Controllable, userInput: String): List<Command> {
        val l = super.suitableCommands(controllable, userInput)
        val inv = controllable.inventory()
        inv.mapIndexed { i, item -> Command("${i + 1}", item.title, emptyList()) }
        return l
    }

    override fun render(controllable: Controllable, renderMode: App.RenderMode) {
        val inv = controllable.inventory()
        if (inv.isEmpty()) {
            println("Инвентарь пуст.")
        } else {
            println("Инвентарь:")
            inv.forEach { println(it.title) }
            println()
        }
    }

}