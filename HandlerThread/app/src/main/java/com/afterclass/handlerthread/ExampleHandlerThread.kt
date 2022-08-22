package com.afterclass.handlerthread

import android.annotation.SuppressLint
import android.os.*
import android.util.Log

class ExampleHandlerThread:HandlerThread("ExampleHandlerThread",Process.THREAD_PRIORITY_BACKGROUND) {
    companion object{
        val EXAMPLE_TASK=1
    }
    var handler: Handler?=null
    override fun onLooperPrepared() {
        handler=object:Handler(){
            @SuppressLint("HandlerLeak")
            override fun handleMessage(msg: Message) {
                when(msg.what){
                    EXAMPLE_TASK -> {
                        Log.d("TAG","Example Task,arg1:${msg.arg1},obj:${msg.obj}")
                        var i = 0
                        while(i<4){
                            Log.d("TAG","handleMessage:${i}")
                            SystemClock.sleep(1000)
                            i++
                        }
                    }
                    else -> {

                        Log.d("TAG","Invalid!")

                    }
                }
                }

            }

        }        }

