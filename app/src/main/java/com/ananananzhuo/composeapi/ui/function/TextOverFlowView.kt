package com.ananananzhuo.composeapi.ui.function

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * author  :mayong
 * function: Text文字超过一定行数自动省略号的方法
 * date    :2022/4/4
 **/
@Composable
fun TextOverflowView() {

    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.Red),
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            Modifier
                .width(300.dp)
                .height(60.dp)
                .background(Color.Green)
        ) {
            Text(
                text = "安安安安卓，一个专注传不android知识的螺丝钉,欢迎关注公众号：安安安安卓",
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                style = TextStyle(fontSize = 30.sp)
            )
        }
    }
}