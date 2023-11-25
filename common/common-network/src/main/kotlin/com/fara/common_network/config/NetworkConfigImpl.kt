package com.fara.common_network.config

internal class NetworkConfigImpl : NetworkConfig {
    override val connectTimeOutSeconds: Long = 45
    override val readTimeoutSeconds: Long = 45
    override val writeTimeoutSeconds: Long = 45
}