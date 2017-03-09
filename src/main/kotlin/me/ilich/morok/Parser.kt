package me.ilich.morok

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import me.ilich.morok.action.Action
import me.ilich.morok.module.Module
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

object Parser {

    private val gson: Gson = GsonBuilder().
            registerTypeAdapter(Action::class.java, ActionDeserializer()).
            create()

    fun parse(file: File): Module {
        val reader = BufferedReader(FileReader(file))
        val module = gson.fromJson(reader, Module::class.java)
        reader.close()
        return module
    }

}