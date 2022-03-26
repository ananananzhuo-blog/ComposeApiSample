package com.ananananzhuo.composeapi.ui.function

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ananananzhuo.composeapi.ui.view.CustomScaffold

/**
 * author  :mayong
 * function:
 * date    :2022/3/26
 **/
@Composable
fun MutableStateListView() {
    val model: TestModel = viewModel()
    CustomScaffold(title = "mutableStateListOf使用") {
        LazyColumn(content = {
            itemsIndexed(model.datas) { index: Int, data: Int ->
                Box(
                    Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .height(50.dp)
                        .border(width = 1.dp, color = Color.Green)
                        .clickable {
                            model.datas.add(index + 1)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    if (index == model.datas.size - 1) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "",
                            tint = Color.Red
                        )
                    } else {
                        Text(text = data.toString())
                    }
                }
            }
        })
    }
}

class TestModel : ViewModel() {
    val datas = mutableStateListOf(0,1)
//    val datas = mutableListOf(0,1,2,3)
}