package com.ananananzhuo.composeapi.ui.function

import android.os.Bundle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.ananananzhuo.composeapi.navigate_param_transfer1
import com.ananananzhuo.composeapi.navigate_param_transfer2

/**
 * author  :mayong
 * function:
 * date    :2022/4/7
 **/

@Composable
fun NavigateParams2View(controller: NavHostController) {
    Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {
        Text(text = "展示下一级页面返回来的数据")
        Button(onClick = {
//            controller.getBackStackEntry(navigate_param_transfer1).arguments?.putString("data",
//                "Hello world to you")
//
//            controller.popBackStack()
            controller.goBackRouteWithParams(navigate_param_transfer1){
                putString("data",
                "Hello world to you")
            }
        }) {
            Text(text = "点击跳转到下一级页面")
        }
        Button(onClick = {
//            controller.previousBackStackEntry?.arguments?.putString("data", "Hello world to you")
//            controller.popBackStack()
            controller.goBackWithParams {
                putString("data", "Hello world to you")
            }
        }) {
            Text(text = "点击跳转到下一级页面")
        }
    }
}

/**
 * 返回指定的route并回调参数
 */
fun NavHostController.goBackRouteWithParams(
    route: String,
    autoPop: Boolean = true,
    callback: (Bundle.() -> Unit)? = null,
) {
    getBackStackEntry(route).arguments?.let {
        callback?.invoke(it)
    }
    if (autoPop) {
        popBackStack()
    }
}

/**
 * 回到上级页面，并回调参数
 */
fun NavHostController.goBackWithParams(
    autoPop: Boolean = true,
    callback: (Bundle.() -> Unit)? = null,
) {
    previousBackStackEntry?.arguments?.let {
        callback?.invoke(it)
    }
    if (autoPop) {
        popBackStack()
    }
}







