package me.ilich.morok.engine

import com.google.gson.annotations.SerializedName
import me.ilich.morok.engine.Scene

open class Module(
        val title: String,
        @SerializedName("start_scene_id") val startSceneId: String,
        val scenes: List<Scene>,
        val include: List<String> = emptyList()
)