package com.ananananzhuo.composeapi

/**
 * author  :mayong
 * function:
 * date    :2022/3/25
 **/


val datas = mutableListOf(
    Data(route = home, title = "首页", desc = "首页"),
    Data(route = fastClick, title = "防快速点击", desc = "compose如何防止快速点击事件"),
    Data(route = launchToActivity, title = "跳转activity返回结果", desc = "从compose跳转到Activity页面，并返回结果")

)

data class Data(val route: String, val title:String,val desc: String)