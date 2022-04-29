package com.ananananzhuo.composeapi

/**
 * author  :mayong
 * function:
 * date    :2022/3/25
 **/


val datas = mutableListOf(
    Data(route = test, title = "测试页面", desc = "测试页面"),

    Data(route = DRAWBACKGROUND, title = "compose绘制背景", desc = "Compose使用drawBehind绘制组合背景"),
    Data(route = navigate_param_transfer1, title = "导航页面之间传递参数", desc = "点击页面内按钮，跳转到下一级页面。在下一级页面点击按钮返回后将参数传递回当前页面"),
    Data(route = keyboardActionKey, title = "compose软键盘如何把换行按钮变换为其它行为", desc = "compose软键盘如何把换行按钮变换为其它行为"),
    Data(route = textoverflow, title = "Text超过一定字数后面加三个点省略", desc = "Text超过一定字数后面加三个点省略"),
    Data(route = keyboardshowandhide, title = "键盘的弹出和关闭", desc = "实现compose的键盘弹出和关闭功能"),
    Data(route = mutableStateListOfUse, title = "mutableStateListOf的使用", desc = "mutableStateListOf的使用，实现列表数据的编辑后实时刷新页面"),
    Data(route = fastClick, title = "防快速点击", desc = "compose如何防止快速点击事件"),
    Data(route = launchToActivity, title = "跳转activity返回结果", desc = "从compose跳转到Activity页面，并返回结果"),
    Data(route = backKey, title = "返回键监听", desc = "返回键监听,使用NavHostController监听页面发生变化"),
)

data class Data(val route: String, val title:String,val desc: String)