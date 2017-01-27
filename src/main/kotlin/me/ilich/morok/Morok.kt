package me.ilich.morok

import me.ilich.morok.demo.DemoWorld

object Morok {

    @JvmStatic fun main(arg: Array<String>) {
        println("begin")
        val reader = ConsoleReader()
        val engine = Engine(DemoWorld())
        while (engine.isWorking()) {
            print("> ")
            val text = reader.read()
            val input = Input(text)
            val output = engine.tick(input)
            println(output.text)
        }
        println("end")
    }

}
