package com.zhouhaoh.plugins.upload.bean

open class UpLoadApkExtension(
    var apiKey: String = "",   // API Key
    var appName: String = "" // 应用名称
) {
    override fun toString(): String {
        return "UpLoadApkExtension(apiKey='$apiKey', appName='$appName')"
    }
}