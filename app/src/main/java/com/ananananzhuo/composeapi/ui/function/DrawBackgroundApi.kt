package com.ananananzhuo.composeapi.ui.function

import android.graphics.BitmapFactory
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.ananananzhuo.composeapi.R

/**
 * author  :mayong
 * function:compose绘制控件背景
 * date    :2022/4/26
 **/
@Composable
fun DrawBackgroundView() {
    Column(Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround) {
        val bitmap = BitmapFactory.decodeResource(LocalContext.current.resources, R.drawable.apple)
        val bitmapWidth = bitmap.width
        val bitmapHeight = bitmap.height
        Box(Modifier.background(Color.Red)) {
            Box(Modifier
                .size(80.dp)
                .drawBehind {
                    drawImage(
                        bitmap.asImageBitmap(),
                        srcSize = IntSize(bitmap.width, bitmap.height),
                        dstSize = IntSize((density * 50).toInt(), (density * 50).toInt()),
                        srcOffset = IntOffset.Zero,
                        dstOffset = IntOffset.Zero
                    )
                }) {
            }
            Text(text = "将图片绘制到成一个宽高50dp的情况")
        }
        Box(Modifier.background(Color.Red)) {
            Box(Modifier
                .size(80.dp)
                .drawBehind {
                    val density = density.toInt()
                    this.drawImage(
                        bitmap.asImageBitmap(),
                        srcOffset = IntOffset(15 * density, 15 * density),
                        srcSize = IntSize(bitmap.width, bitmap.height),
                        dstOffset = IntOffset(40 * density, 40 * density),
                        dstSize = IntSize(density * 35, density * 35)
                    )
                    //                        dstSize = IntSize(density * 50, density * 50)
                }) {
            }
            Text(text = "将图片绘制到成一个宽高50dp的情况")
        }
    }
}

