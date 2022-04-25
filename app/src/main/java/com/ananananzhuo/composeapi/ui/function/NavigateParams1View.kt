package com.ananananzhuo.composeapi.ui.function

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ananananzhuo.composeapi.navigate_param_transfer2

/**
 * author  :mayong
 * function:
 * date    :2022/4/7
 **/

@Composable
fun NavigateParams1View(controller: NavHostController) {
    val bundle = controller.currentBackStackEntryAsState().value
    Column(Modifier
        .fillMaxSize()
        .background(Color.Red), verticalArrangement = Arrangement.Center) {
        Text(text = "展示下一级页面返回来的数据")
        Text(text = bundle?.arguments?.getString("data")?:"未返回数据")
        Button(onClick = {
            controller.navigate(navigate_param_transfer2)
        }) {
            Text(text = "点击跳转到下一级页面")
        }

    }
}