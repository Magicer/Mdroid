package xyz.magicer.mdroid.utils

import android.util.Log

const val DEFAULT_TAG = "Magicer"


fun logI(msg: String) {
    logI(DEFAULT_TAG, msg)
}

fun logI(tag: String, msg: String) {
    Log.i(tag, msg)
}


fun logD(msg: String) {
    logD(DEFAULT_TAG, msg)
}

fun logD(tag: String, msg: String) {
    Log.d(tag, msg)
}

fun logE(msg: String) {
    logE(DEFAULT_TAG, msg)
}

fun logE(tag: String, msg: String) {
    Log.e(tag, msg)
}
