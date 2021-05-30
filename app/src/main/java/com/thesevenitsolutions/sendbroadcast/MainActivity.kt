package com.thesevenitsolutions.sendbroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnsendmessage.setOnClickListener {

                sendBroadcast(Intent("com.thesevenitsolutions.listviewandrecyclerview.EXAMPLE_ACTION").putExtra("com.thesevenitsolutions.listviewandrecyclerview.EXTRA_TEXT","Broadcast received"))
        }
    }

    var broadcastReceiver= object :BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            var receivedText:String? = intent?.getStringExtra("com.thesevenitsolutions.listviewandrecyclerview.EXTRA_TEXT")
            tvmessage.text = receivedText

        }

    }

    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter("com.thesevenitsolutions.listviewandrecyclerview.EXAMPLE_ACTION")
        registerReceiver(broadcastReceiver,intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcastReceiver)
    }
}