package me.ilich.morok.world

enum class Direction(val x: Int, val y: Int) {
    N(0, 1),
    NE(1, 1),
    E(1, 0),
    ES(1, -1),
    S(0, -1),
    SW(-1, -1),
    W(-1, 0),
    NW(-1, 1);

    fun pos(): Pair<Int, Int> = Pair(x, y)

}