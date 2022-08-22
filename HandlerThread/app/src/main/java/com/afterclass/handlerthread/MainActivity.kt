package com.afterclass.handlerthread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.os.SystemClock
import android.util.Log
import android.view.View


class MainActivity : AppCompatActivity() {

    val ExampleHandlerThread=ExampleHandlerThread()
    val runnable1=Companion.ExampleRunnable1()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ExampleHandlerThread.start()
    }
    fun doWork(view:View){

        val message = Message.obtain()
        message.what=1
        message.arg1=23
        message.obj="Obj String"


        ExampleHandlerThread.handler?.sendMessage(message)
        ExampleHandlerThread.handler?.post(ExampleRunnable1())
        ExampleHandlerThread.handler?.post(runnable1)
        /*  ExampleHandlerThread.handler?.post(ExampleRunnable1())
        ExampleHandlerThread.handler?.postAtFrontOfQueue(ExampleRunnable2())*/

    }
    fun removeMessages(view:View){
       ExampleHandlerThread.handler?.removeCallbacks(runnable1)
    }

    override fun onDestroy() {
        super.onDestroy()
        ExampleHandlerThread.quit()
    }

    companion object{
        class ExampleRunnable1:Runnable{
            override fun run() {
                var i = 0
                while(i<5){
                    Log.d("TAG","Runnable1:${i}")
                    SystemClock.sleep(1000)
                    i++
                }
            }

        }
        class ExampleRunnable2:Runnable{
            override fun run() {
                var i = 0
                while(i<5){
                    Log.d("TAG","Runnable2:${i}")
                    SystemClock.sleep(1000)
                    i++
                }
            }

        }
    }
}