package me.ilich.morok.parser

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import me.ilich.morok.engine.Action
import me.ilich.morok.engine.Item
import me.ilich.morok.engine.Module
import me.ilich.morok.engine.Scene
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

object Parser {

    private val gson: Gson = GsonBuilder().
            registerTypeAdapter(Module::class.java, ModuleDeserializer()).
            registerTypeAdapter(Scene::class.java, SceneDeserializer()).
            registerTypeAdapter(Action::class.java, ActionDeserializer()).
            create()

    fun parseHeader(file: File): ModuleHeader {
        val reader = BufferedReader(FileReader(file))
        val module = gson.fromJson(reader, ModuleHeader::class.java)
        return module
    }

    fun parse(file: File, listener: Listener) {
        val reader = BufferedReader(FileReader(file))
        val module = gson.fromJson(reader, Module::class.java)
        if (module.startSceneId != null) {
            listener.onStartSceneId(module.startSceneId)
        }
        module.include?.forEach { fileName ->
            listener.onInclude(fileName)
        }
        module.scenes?.forEach { scene ->
            listener.onScene(scene)
        }
        module.items?.forEach { item ->
            listener.onItem(item)
        }
        reader.close()
    }

    interface Listener {
        fun onInclude(moduleFileName: String)
        fun onStartSceneId(startSceneId: String)
        fun onScene(scene: Scene)
        fun onItem(item: Item)
    }

}