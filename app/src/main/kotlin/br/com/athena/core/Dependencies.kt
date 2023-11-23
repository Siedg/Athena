package br.com.athena.core

object Config {
    const val minSdk = 26
    const val compileSdk = 33
    const val targetSdk = 33
}

object Versions {
    // Tools
    const val kotlin = "1.7.20"

    // Others
    const val retrofit = "2.9.0"

    // Compose
    const val composeUI = "1.3.3"
}

object Deps {
    // Tools Dependencies
    const val tools_kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}