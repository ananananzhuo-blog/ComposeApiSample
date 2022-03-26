package com.ananananzhuo.composeapi.ui.function

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * author  :mayong
 * function:
 * date    :2022/3/26
 **/


@Composable
fun AvoidFastClick() {
    var color by remember {
        mutableStateOf(Color.Red)
    }
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "每点击一次，背景会变色一次，如果快速多次点击，因为有防快速点击机制，则不会变色多次")
        Box(
            Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(color)
                .clickable {
                    color = if (color == Color.Red) Color.Green else Color.Red
                }, contentAlignment = Alignment.Center) {
            Text(text = "点击变色无快速点击机制")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(color)
                .avoidRepeatclickable {
                    color = if (color == Color.Red) Color.Green else Color.Red
                }, contentAlignment = Alignment.Center) {
            Text(text = "点击变色有快速点击机制")
        }
    }

}


@Composable
fun Modifier.avoidRepeatclickable(millis: Long = 500, onClick: () -> Unit): Modifier {
    var timeStamp by remember {
        mutableStateOf(0L)
    }

    return clickable {
        if (System.currentTimeMillis() - timeStamp > millis) {
            onClick()
            timeStamp = System.currentTimeMillis()
        }
    }
}