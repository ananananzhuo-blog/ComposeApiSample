package com.ananananzhuo.composeapi

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.activity.OnBackPressedDispatcher

/**
 * author  :mayong
 * function:
 * date    :2022/3/26
 **/
class App: Application() {
    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var CONTEXT :Context
    }
    override fun onCreate() {
        super.onCreate()
        CONTEXT = applicationContext
    }
}