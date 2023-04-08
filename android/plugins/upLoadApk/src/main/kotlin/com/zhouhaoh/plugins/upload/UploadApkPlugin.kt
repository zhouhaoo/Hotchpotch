package com.zhouhaoh.plugins.upload

import com.android.build.gradle.AppExtension
import com.zhouhaoh.plugins.upload.bean.UpLoadApkExtension
import com.zhouhaoh.plugins.upload.task.PgyUploadApkTask
import com.zhouhaoh.plugins.upload.task.TestTask
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * apk打包上传
 */
class UploadApkPlugin : Plugin<Project> {
    override fun apply(project: Project) {

        //uploadApk扩展信息,注意写成open，不能用data Class
        val upLoadApkExtension = project.extensions.create(
            Constants.UPLOAD_APK_EXTENSION,
            UpLoadApkExtension::class.java
        )
        //需要在解析完gradle之后，即afterEvaluate后，才能拿到闭包的值。（Configure project阶段）
        project.afterEvaluate {
            println("uploadApk扩展信息:${upLoadApkExtension}")
            val appExtension =
                project.extensions.findByName(Constants.ANDROID_EXTENSION) as AppExtension
            appExtension.applicationVariants.all { variant ->
                println("变体：${variant.name}")
                val uploadApkTask =
                    project.tasks.create(
                        "tgyUploadApk${variant.name}",
                        PgyUploadApkTask::class.java,
                        "upLoadApkExtension", "dddd"
                    )
                val sendMsg =
                    project.tasks.create(
                        "TestTask${variant.name}",
                        TestTask::class.java
                    )
                variant.assembleProvider.get().dependsOn(project.tasks.findByName("clean"))
                uploadApkTask.setOnlyIf { variant.name == "release" }
                uploadApkTask.dependsOn(variant.assembleProvider.get())
                sendMsg.dependsOn(uploadApkTask)

            }
        }
    }
}