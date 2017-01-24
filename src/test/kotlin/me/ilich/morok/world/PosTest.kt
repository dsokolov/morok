package me.ilich.morok.world

import org.junit.Assert.assertEquals
import org.junit.Test

class PosTest {

    @Test fun a() {
        assertEquals(Pos(0, 0), Pos(0, 0))
        assertEquals(Pos(0, 0), Pos(-1, -1) + Pos(1, 1))
        assertEquals(Pos(1, -1), Pos(1, 0) - Pos(0, 1))
    }


}