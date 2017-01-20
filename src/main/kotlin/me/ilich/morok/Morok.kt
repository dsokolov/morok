package me.ilich.morok

object Morok {

    @JvmStatic fun main(arg: Array<String>) {
        println("begin")
        val reader = ConsoleReader()
        val engine = Engine()
        while (engine.isWorking()) {
            print("> ")
            reader.read { text ->
                val input = Input(text)
                val output = engine.tick(input)
                println(output.text)
            }
        }
        println("end")
    }

}
