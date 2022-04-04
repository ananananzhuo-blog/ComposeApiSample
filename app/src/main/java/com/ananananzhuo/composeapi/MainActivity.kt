package com.ananananzhuo.composeapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ananananzhuo.composeapi.ui.function.*
import com.ananananzhuo.composeapi.ui.theme.ComposeApiSampleTheme
import com.ananananzhuo.composeapi.ui.view.CustomScaffold
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApiSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greet()
                }
            }
        }
    }
}
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Greet() {
    val controller = rememberAnimatedNavController()
    AnimatedNavHost(navController = controller,
        startDestination = home,
        enterTransition = {
           slideInHorizontally(animationSpec = tween(500)) {
               -it
           }
        },
        popEnterTransition = {
           slideInHorizontally(tween(500)) { it }
        }) {
        composable(test){
            Test()
        }
        composable(keyboardActionKey){
            KeyBoardActionKey()
        }
        composable(keyboardshowandhide){
            KeyboardShowAndHide()
        }
        composable(textoverflow){
            TextOverflowView()
        }
        composable(mutableStateListOfUse){
            MutableStateListView()
        }
        composable(home){
            Home(controller)
        }
        composable(fastClick){
            AvoidFastClick()
        }
        composable(launchToActivity){
            LaunchToActivity(controller)
        }
        composable(backKey){
            BackKey(controller)
        }
        composable(back1){
            Back1(controller)
        }
        composable(back2){
            Back2(controller)
        }

    }

}

@Composable
fun Home(controller: NavHostController) {
    CustomScaffold(title = "首页") {
        LazyColumn(content = {
            items(datas){data->
                Column(
                    Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .border(width = 1.dp, color = Color.Green, shape = RoundedCornerShape(5.dp))
                        .clickable {
                            controller.navigate(data.route)
                        }
                        .padding(7.dp)
                ) {
                    Text(text = data.title, style = TextStyle(fontSize = 14.sp))
                    Text(text = data.desc, style = TextStyle(fontSize = 12.sp, color = Color(0xff333333)), modifier = Modifier.padding(top = 8.dp))
                }
            }
        }, modifier = Modifier.fillMaxSize())
    }

}