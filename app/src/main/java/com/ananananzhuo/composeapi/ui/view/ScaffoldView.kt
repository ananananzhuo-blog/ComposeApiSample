package com.ananananzhuo.composeapi.ui.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

/**
 * author  :mayong
 * function:
 * date    :2022/3/26
 **/

/**
 * author  :mayong
 * function:
 * date    :2022/3/26
 **/

@Composable
fun CustomScaffold(title:String, controller: NavHostController?=null, content: @Composable (PaddingValues) -> Unit){
    Scaffold (topBar = {
        TopAppBar(title = {
            Text(title)
        }, navigationIcon = {
            IconButton(onClick = {
                controller?.popBackStack()
            }) {
                Icon(Icons.Filled.ArrowBack, "")
            }
        })

    }){
        content(it)
    }
}