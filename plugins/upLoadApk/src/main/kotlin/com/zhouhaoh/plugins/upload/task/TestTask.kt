package com.zhouhaoh.plugins.upload.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import javax.inject.Inject

open class TestTask @Inject constructor() : DefaultTask() {
    @Input
    var greeting = "hello from GreetingTask"
    init {
        group = "uploadApk"
        description = "上传apk到蒲公英"
    }

    @TaskAction
    fun action() {
        println("TestTask  执行1  $greeting")
    }

}