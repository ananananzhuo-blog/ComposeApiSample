package com.ananananzhuo.composeapi

/**
 * author  :mayong
 * function:
 * date    :2022/3/25
 **/


val datas = mutableListOf(
    Data(route = test, title = "测试页面", desc = "测试页面"),
    Data(route = mutableStateListOfUse, title = "mutableStateListOf的使用", desc = "mutableStateListOf的使用，实现列表数据的编辑后实时刷新页面"),
    Data(route = fastClick, title = "防快速点击", desc = "compose如何防止快速点击事件"),
    Data(route = launchToActivity, title = "跳转activity返回结果", desc = "从compose跳转到Activity页面，并返回结果"),
    Data(route = backKey, title = "返回键监听", desc = "返回键监听,使用NavHostController监听页面发生变化"),

)

data class Data(val route: String, val title:String,val desc: String)