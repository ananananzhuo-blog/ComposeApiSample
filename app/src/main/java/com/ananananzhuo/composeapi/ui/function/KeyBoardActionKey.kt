package com.ananananzhuo.composeapi.ui.function

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.ananananzhuo.composeapi.utils.showToast

/**
 * author  :mayong
 * function:
 * date    :2022/4/4
 **/
data class KeyBoardActionData(val placeHolder: String, val imeAction: ImeAction)

@Composable
fun KeyBoardActionKey() {
    var text by remember {
        mutableStateOf("")
    }
    val imeActions = mutableListOf(
        KeyBoardActionData("什么都没有", ImeAction.Done),
        KeyBoardActionData("go", ImeAction.Go),
        KeyBoardActionData("下一步", ImeAction.Next),
        KeyBoardActionData("上一步", ImeAction.Previous),
        KeyBoardActionData("搜索", ImeAction.Search),
        KeyBoardActionData("发送", ImeAction.Send)
    )
    LazyColumn(content = {
        items(imeActions) { actionData ->
            OutlinedTextField(value = text, onValueChange = {
                text = it
            },
                modifier = Modifier.padding(top = 20.dp).fillMaxWidth().padding(horizontal = 14.dp),
                placeholder = {
                    Text(text = actionData.placeHolder)
                },
                singleLine = true, keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = actionData.imeAction
                ), keyboardActions = KeyboardActions(
                    onDone = {
                        showToast("onDone")
                    },
                    onGo = {
                        showToast("onGo")
                    },
                    onNext = {
                        showToast("onNext")
                    },
                    onPrevious = {
                        showToast("onPrevious")
                    },
                    onSearch = {
                        showToast("onSearch")
                    },
                    onSend = {
                        showToast("onSend")
                    }
                ))
        }
    }, modifier = Modifier.fillMaxSize())
}