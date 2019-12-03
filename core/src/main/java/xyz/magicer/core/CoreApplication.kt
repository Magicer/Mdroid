package xyz.magicer.core

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

abstract class CoreApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (debug()) {
            Debug = true
            ARouter.openDebug()
            ARouter.openLog()
        } else {
            Debug = false
        }
        ARouter.init(this)
    }

    abstract fun debug(): Boolean
}