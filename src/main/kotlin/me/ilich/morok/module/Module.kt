package me.ilich.morok.module

import com.google.gson.annotations.SerializedName
import me.ilich.morok.scene.Scene

open class Module(
        val title: String,
        @SerializedName("start_scene_id") val startSceneId: String,
        val scenes: List<Scene>
)