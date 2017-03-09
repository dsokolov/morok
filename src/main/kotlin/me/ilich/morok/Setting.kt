package me.ilich.morok

import com.google.gson.annotations.SerializedName

data class Setting(
        val title: String,
        @SerializedName("start_scene_id") val startSceneId: String,
        val scenes: List<Scene>
)