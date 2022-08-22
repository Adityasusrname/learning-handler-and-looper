package com.afterclass.looper_messagequeue_and_handler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.Button
import com.afterclass.looper_messagequeue_and_handler.ExampleHandler.Companion.TASK_A
import com.afterclass.looper_messagequeue_and_handler.ExampleHandler.Companion.TASK_B

class MainActivity : AppCompatActivity() {


    private val ExampleLooperThread=ExampleLopperThread()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         val btnStart = findViewById<Button>(R.id.start)
         val btnStop = findViewById<Button>(R.id.stop)
         val btnTaskA = findViewById<Button>(R.id.taskA)
         val btnTaskB = findViewById<Button>(R.id.taskB)
    }

    fun startThread(view: View){
        ExampleLooperThread.start()
    }
    fun stopThread(view:View){
        ExampleLooperThread.looper?.quit()
    }
    fun taskA(view:View){

        val message = Message.obtain()
        message.what=TASK_A
        ExampleLooperThread.handler?.sendMessage(message)

       /* ExampleLooperThread.handler?.post(Runnable {

            //Has an implicit reference to MainActivity
            //Activity can't be garbage collected because of this
            //The app will crash

            var i = 0
            while(i<5){
                Log.d("TAG","run:${i}")
                SystemClock.sleep(1000)
                i++
            }
        })*/

    }
    fun taskB(view:View){

        val message = Message.obtain()
        message.what=TASK_B
        ExampleLooperThread.handler?.sendMessage(message)

    }


}