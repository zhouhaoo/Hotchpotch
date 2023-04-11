package com.zhouhaoh.hotchpotch.sample

import android.app.Application
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.FlutterEngineGroup
import io.flutter.embedding.engine.dart.DartExecutor
class App : Application() {

    lateinit var flutterEngine: FlutterEngine
    val flutterEngineGroup get() = _flutterEngineGroup
    private lateinit var _flutterEngineGroup: FlutterEngineGroup
    override fun onCreate() {
        super.onCreate()
        flutterEngine = FlutterEngine(this)
        _flutterEngineGroup = FlutterEngineGroup(this)
//        flutterEngine.navigationChannel.setInitialRoute("your/route/here");
        flutterEngine.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint.createDefault()
        )
        flutterEngine.navigationChannel.pushRoute("xxx")
        FlutterEngineCache
            .getInstance()
            .put("my_engine_id", flutterEngine)

    }
}