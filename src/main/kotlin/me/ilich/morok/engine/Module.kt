package me.ilich.morok.engine

open class Module(
        val title: String? = null,
        val startSceneId: String? = null,
        val scenes: List<Scene>? = null,
        val items: List<Item>? = null,
        val include: List<String>? = null
)