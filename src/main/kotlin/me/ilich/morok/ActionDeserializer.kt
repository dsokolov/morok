package me.ilich.morok

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import me.ilich.morok.engine.Action
import me.ilich.morok.system.EchoAction
import me.ilich.morok.system.GotoAction
import java.lang.reflect.Type

class ActionDeserializer : JsonDeserializer<Action> {

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Action {
        val type = json.asJsonObject["type"].asString
        val action = when (type) {
            "goto" -> {
                val sceneId = json.asJsonObject["scene_id"].asString
                GotoAction(sceneId)
            }
            "echo" -> {
                val textJsonObject = json.asJsonObject["text"]
                val text = if (textJsonObject.isJsonArray) {
                    textJsonObject.asJsonArray.map { it.asString }
                } else if (textJsonObject.isJsonPrimitive) {
                    listOf(textJsonObject.asString)
                } else {
                    emptyList()
                }
                EchoAction(text)
            }
            else -> TODO(type)
        }
        return action
    }

}