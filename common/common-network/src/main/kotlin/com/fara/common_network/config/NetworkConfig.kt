package com.fara.common_network.config

internal interface NetworkConfig {
    val connectTimeOutSeconds: Long
    val readTimeoutSeconds: Long
    val writeTimeoutSeconds: Long
}