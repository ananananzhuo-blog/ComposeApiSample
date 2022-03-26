package com.ananananzhuo.composeapi.ui.function

import android.os.Bundle
import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.addCallback
import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import com.ananananzhuo.composeapi.back1
import com.ananananzhuo.composeapi.back2
import com.ananananzhuo.composeapi.ui.view.CustomScaffold
import com.ananananzhuo.composeapi.utils.log
import com.ananananzhuo.composeapi.utils.showToast

/**
 * author  :mayong
 * function:
 * date    :2022/3/26
 **/

@Composable
fun BackKey(controller: NavHostController) {
    CustomScaffold(title = "返回键监控方法") {
        LazyColumn(content = {
            item{
                Button(onClick = {
                    controller.navigate(back1)
                }) {
                    Text(text = "跳转到BackHandler监听返回键")
                }
            }
            item{
                Button(onClick = {
                    controller.navigate(back2)
                }) {
                    Text(text = "跳转使用OnBackPressedDispatcher监听返回键被点击")
                }
            }
        }, modifier = Modifier.fillMaxSize())
    }

    controller.addOnDestinationChangedListener(object :NavController.OnDestinationChangedListener{
        override fun onDestinationChanged(
            controller: NavController,
            destination: NavDestination,
            arguments: Bundle?
        ) {
            log("路由变化：${destination.route}")
        }
    })
}

@Composable
fun Back1(controller: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Red)
            .clickable {
                controller.popBackStack()
            }) {
        Text(text = "点击返回上一个页面")
        Text(text = "使用BackHandler实现返回键监听")
    }
    BackHandler(enabled = true) {
        Log.e("tag","返回键被点击")
    }
}
@Composable
fun Back2(controller: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Green)
            .clickable {
                controller.popBackStack()
            }) {
        Text(text = "点击返回上一个页面")
        Text(text = "使用OnBackPressedDispatcher监听返回键被点击")
    }
    val callback = remember {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                log("回退键被点击")
                showToast("监听到返回键被点击监听")
            }
        }
    }
    val dispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    DisposableEffect(key1 = Unit, effect = {
        dispatcher?.addCallback(callback)
        onDispose {
            callback.remove()
        }
    })
}