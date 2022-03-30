package com.zhouhaoh.plugins.upload

import org.gradle.api.Plugin
import org.gradle.api.Project
import com.android.build.gradle.AppExtension

/**
 * apk打包上传
 */
class UploadApkPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        println("---------kotlin plugins test")
        project.afterEvaluate {
            val appExtension = project.extensions.findByName("android") as AppExtension
            appExtension.applicationVariants.all {

            }
        }
    }
}