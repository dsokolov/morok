package me.ilich.morok2

interface Setting {
    fun nextScene(): Scene
    fun hasNextScene(): Boolean
    fun processInput(input: String, currentScene: Scene)
    fun stop()
}