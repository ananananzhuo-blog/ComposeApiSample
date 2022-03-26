package com.ananananzhuo.composeapi.ui.function

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ananananzhuo.composeapi.activity.GenerateActivityResultActivity
import com.ananananzhuo.composeapi.ui.未命名文件夹.CustomScaffold

/**
 * author  :mayong
 * function:
 * date    :2022/3/26
 **/
@Composable
fun LaunchToActivity(controller: NavHostController, ) {
    var activityResult by remember {
        mutableStateOf("")
    }
    val launcher = rememberLauncherForActivityResult(contract =object : ActivityResultContract<String, String>() {
        override fun parseResult(resultCode: Int, intent: Intent?): String {
           return intent?.getStringExtra("data")?:""
        }

        /**
         * @param compose向Compose中传的数据 ActivityResultContract<String, String>的第一个泛型
         */
        override fun createIntent(context: Context, input: String?): Intent {
            return Intent(context,GenerateActivityResultActivity::class.java).apply {
                putExtra("data",input)
            }
        }
    } , onResult = {result-> //result 是ActivityResultContract<String, String>第二个泛型
        activityResult = result
    })
    CustomScaffold(controller = controller, title = "从compose跳转到Activity并返回结果") {
        Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                launcher.launch("Hello")
            }) {
                Text(text = "跳转到Activity页面")
            }
            Box(
                Modifier
                    .fillMaxWidth(0.8f)
                    .height(100.dp), contentAlignment = Alignment.Center) {
                Text(text = "获取到返回结果:=$activityResult")
            }
        }
    }
}

