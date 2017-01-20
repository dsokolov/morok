package me.ilich.morok

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class ConsoleReader {

    private var br = BufferedReader(InputStreamReader(System.`in`))

    fun read(callback: (String) -> (Unit)) {
        val input = br.readLine()
        callback(input)
    }

    fun stop() {
        try {
            br.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

}
