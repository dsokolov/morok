package me.ilich.morok.world

interface World {

    fun currentRoomId(): String

    fun roomById(id: String): Room

}