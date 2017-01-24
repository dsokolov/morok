package me.ilich.morok.world

data class Pos(val x: Int, val y: Int) {

    operator fun plus(p: Pos): Pos = Pos(x + p.x, y + p.y)

    operator fun minus(p: Pos): Pos = Pos(x - p.x, y - p.y)

}