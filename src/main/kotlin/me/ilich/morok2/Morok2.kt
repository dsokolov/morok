package me.ilich.morok2

import me.ilich.morok.demo.DemoWorld
import me.ilich.morok2.demo.DemoSetting
import java.io.BufferedReader
import java.io.InputStreamReader

object Morok2 {

    @JvmStatic fun main(arg: Array<String>) {
        val setting: Setting = DemoSetting()
        val br = BufferedReader(InputStreamReader(System.`in`))
        while (setting.hasNextScene()) {
            val view = View()
            val scene = setting.nextScene()
            scene.render(view)
            println(view.render())
            print(" > ")
            val input = br.readLine()
            setting.processInput(input, scene)
        }
        br.close()
    }

}
