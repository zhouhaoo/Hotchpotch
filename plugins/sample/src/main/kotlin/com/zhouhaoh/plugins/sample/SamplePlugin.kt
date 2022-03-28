package com.zhouhaoh.plugins.sample

import org.gradle.api.Plugin
import org.gradle.api.Project

class SamplePlugin : Plugin<Project> {
    override fun apply(project: Project) {
       println("---------kotlin")
    }
}