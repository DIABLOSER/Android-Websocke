package com.daboluo.myapplication

import android.os.Bundle
import android.provider.CalendarContract.CalendarCache.URI
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONObject
import java.net.URI

class MainActivity : AppCompatActivity() {

    private lateinit var webSocketManager: WebSocketManager
    private lateinit var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        editText = findViewById(R.id.editText)

        // 初始化WebSocket连接
        val androidId = "android123"  // 每个客户端唯一ID
        webSocketManager = WebSocketManager(Common.SERVER_URL, androidId) {
            editText.text.toString()
        }
        webSocketManager.connect()
    }

    override fun onDestroy() {
        webSocketManager.disconnect()
        super.onDestroy()
    }

}