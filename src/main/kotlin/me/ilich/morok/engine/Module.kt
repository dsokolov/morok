package me.ilich.morok.engine

open class Module(
        val title: String,
        val startSceneId: String,
        val scenes: List<Scene>,
        val items: List<Item> = emptyList(),
        val include: List<String> = emptyList()
)