package me.ilich.morok

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
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
                val text = json.asJsonObject["text"].asString
                EchoAction(text)
            }
            else -> TODO(type)
        }
        return action
    }

}