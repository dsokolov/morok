package me.ilich.morok

object ExitCommand : Command(
        key = "ВЫХОД",
        title = "Выход",
        actions = listOf(ExitAction())
)