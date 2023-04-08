package com.zhouhaoh.hotchpotch.sample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.zhouhaoh.hotchpotch.sample.R
import io.flutter.embedding.android.FlutterActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            val bufferedReader = assets.open("file.text").bufferedReader()
            val readLine = bufferedReader.readLine()
            val readLine2 = bufferedReader.readLine()
            println("Assets目录测试结果来源1：$readLine")
            println("Assets目录测试结果来源2：$readLine2")
        } catch (e: Exception) {
        }
        findViewById<Button>(R.id.bt_flutter).setOnClickListener {
            startActivity(
                FlutterActivity.createDefaultIntent(this)
            )
        }
    }
}