package me.ilich.morok2.demo

import me.ilich.morok2.Command
import me.ilich.morok2.Scene
import me.ilich.morok2.View

class HelloScene : Scene() {

    override val commands: List<Command> = listOf(
            PlayCommand(),
            HelpCommand(),
            ExitCommand()
    )

    override fun render(view: View) {
        view.println("*** Морок DEV ***")
        view.println("PLAY (ИГРАТЬ) - начать игру")
        view.println("HELP (СПРАВКА) - справка")
        view.println("QUIT (ВЫХОД) - выход (неожиданно, да?)")
    }

}