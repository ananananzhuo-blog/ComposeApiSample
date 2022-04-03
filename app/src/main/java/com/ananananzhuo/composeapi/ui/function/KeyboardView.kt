package com.ananananzhuo.composeapi.ui.function

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp

/**
 * author  :mayong
 * function:
 * date    :2022/4/3
 **/

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun KeyboardShowAndHide() {
    var text by remember {
        mutableStateOf("")
    }
    val requester = remember {//用于请求焦点的对象
        FocusRequester()
    }
    val keyboard = LocalSoftwareKeyboardController.current//用于操作键盘的对象
    LaunchedEffect(key1 = Unit, block = {
        requester.requestFocus()//首次进入和重组页面请求焦点
        keyboard?.show()//首次进入页面弹出键盘，注意必须先获取焦点才能弹出键盘成功
    })
    Column(
        Modifier
            .padding(top = 150.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = text, onValueChange = {
                text = it
            }, modifier = Modifier.focusRequester(requester)//focusRequester方法表明让OutLineTextField可以获取焦点
        )
        Button(onClick = {
            requester.requestFocus()//替OutLineTextField请求焦点，一定要获取焦点才能操作键盘
            keyboard?.hide()//关闭键盘
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "关闭键盘")
        }
    }
}