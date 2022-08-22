package com.afterclass.startabackgroundthread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private var btnStart:Button?=null
    private val mainHandler = Handler(Looper.getMainLooper())
    private @Volatile var flag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnStart = findViewById(R.id.btnStart)
    }
    fun startThread(view:View){

        flag = false
        /*  val ExampleThread = ExampleThread(10)
        ExampleThread.start() */

        val ExampleRunnable = ExampleRunnable(10)
        Thread(ExampleRunnable).start()
    }

    fun stopThread(view:View){

        flag = true

    }

   inner class ExampleThread(val seconds:Int):Thread(){
        override fun run() {
            var i = 0
            while(i < seconds){
                Log.d("TAG","We are at i = ${i}")
                Thread.sleep(1000)
                i++
            }


        }
    }

   inner class ExampleRunnable(val seconds:Int) : Runnable{
        override fun run() {
            var i = 0
            while(i < seconds){
                if(i==5){

                     val threadHandler=Handler(Looper.getMainLooper())

                      /* mainHandler.post(Runnable {
                       btnStart?.text="50%"
                      })*/

                 /*   threadHandler.post(Runnable {
                        btnStart?.text="50%"
                    })*/

                    runOnUiThread(Runnable {
                        btnStart?.text="50%"
                    })


                }
                if(flag)
                    return
                Log.d("TAG","We are at i = ${i}")
                Thread.sleep(1000)
                i++
            }
        }

    }


}