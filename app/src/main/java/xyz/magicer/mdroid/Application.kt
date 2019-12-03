package xyz.magicer.mdroid

import xyz.magicer.core.CoreApplication

class Application : CoreApplication() {

    override fun debug(): Boolean {
        return BuildConfig.DEBUG
    }

}