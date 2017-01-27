package me.ilich.morok.demo

import me.ilich.morok.Engine
import me.ilich.morok.world.Room

class VoidRoom : Room() {

    override fun description(engine: Engine): String {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun preview(): String {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}