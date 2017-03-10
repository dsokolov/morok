package me.ilich.morok.parser

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import me.ilich.morok.engine.Item
import me.ilich.morok.engine.Module
import me.ilich.morok.engine.Scene
import java.lang.reflect.Type

class ModuleDeserializer : JsonDeserializer<Module> {

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Module {
        val title = json.asJsonObject["title"]?.asString ?: ""
        val startSceneId = json.asJsonObject["start_scene_id"]?.asString ?: ""
        val include = json.asJsonObject["include"]?.asJsonArray?.map { it.asString } ?: emptyList()
        val scenes = json.asJsonObject["scenes"]?.asJsonArray?.map { context.deserialize<Scene>(it, Scene::class.java) } ?: emptyList()
        val items = json.asJsonObject["items"]?.asJsonArray?.map { context.deserialize<Item>(it, Item::class.java) } ?: emptyList()
        return Module(
                title = title,
                startSceneId = startSceneId,
                include = include,
                scenes = scenes,
                items = items
        )
    }

}