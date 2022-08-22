package com.afterclass.looper_messagequeue_and_handler


import android.os.Looper
import android.util.Log

class ExampleLopperThread:Thread() {
    var handler: ExampleHandler? =null
    var looper:Looper?=null
    override fun run() {

        Log.d("TAG","Started!")
        Looper.prepare()
        looper=Looper.myLooper()
        handler = ExampleHandler()
        Looper.loop()


        Log.d("TAG","end of run()!")
    }

}