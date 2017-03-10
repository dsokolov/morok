package me.ilich.morok.system

import me.ilich.morok.engine.Command
import me.ilich.morok.engine.Scene

class InventoryShowScene : Scene(
        id = ID,
        description = emptyList(),
        title = "Инвентарь",
        commands = listOf(Command("0", "вернуться", listOf(ReturnAction())))
) {

    companion object {
        const val ID = "system_inventory_show"
    }

}