package com.ananananzhuo.composeapi.utils

import android.content.Context
import android.widget.Toast
import com.ananananzhuo.composeapi.App

/**
 * author  :mayong
 * function:
 * date    :2022/3/26
 **/

fun showToast(text:String,context:Context = App.CONTEXT){
    Toast.makeText(context,text,Toast.LENGTH_LONG).show()
}