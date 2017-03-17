package me.ilich.morok.parser

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import me.ilich.morok.engine.*
import java.lang.reflect.Type

class SceneDeserializer : JsonDeserializer<Scene> {

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Scene {
        val id = json.asJsonObject["id"]?.asString ?: throw NullPointerException("id")
        val title = json.asJsonObject["title"]?.asString ?: ""
        val description = json.asJsonObject["description"]?.asJsonArray?.map { it.asString } ?: emptyList()
        val commands = json.asJsonObject["commands"]?.asJsonArray?.map { context.deserialize<Command>(it, Command::class.java) } ?: emptyList()
        val items = json.asJsonObject["items"]?.asJsonArray?.map { it.asString } ?: emptyList()
        return SimpleScene(
                id = id,
                title = title,
                description = description,
                availableCommands = Scene.AvailableCommands.ALL,
                commands = commands,
                itemIds = items
        )
    }

}