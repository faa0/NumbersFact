package com.fara.common_network.config

import javax.inject.Inject

internal class NetworkConfigImpl @Inject constructor() : NetworkConfig {

    override val connectTimeOutSeconds: Long = 60
    override val readTimeoutSeconds: Long = 30
    override val writeTimeoutSeconds: Long = 30
}