package com.afterclass.looper_messagequeue_and_handler

import android.os.Handler
import android.os.Message
import android.util.Log

class ExampleHandler:Handler() {

    companion object{
        val TASK_A = 1
        val TASK_B = 2
    }

    override fun handleMessage(msg: Message) {

        when(msg.what){

            TASK_A -> Log.d("TAG","Task A executed!")
            TASK_B -> Log.d("TAG","Task B executed!")
            else ->   Log.d("TAG","Invalid msg.what")

        }
    }
}