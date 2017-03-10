package me.ilich.morok.system

import me.ilich.morok.engine.Command

class InventoryCommand : Command(
        "инвентарь",
        "инв",
        actions = listOf(GosubAction(InventoryShowScene.ID))
)