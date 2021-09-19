package com.anlab.signalr_example

import java.security.cert.X509Certificate
import javax.net.ssl.X509TrustManager

/**
 * Позволяет доверять всем сертификатом.
 */
class TrustAllCerts : X509TrustManager {
    override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
    override fun checkClientTrusted(certs: Array<X509Certificate>, authType: String) = Unit
    override fun checkServerTrusted(certs: Array<X509Certificate>, authType: String) = Unit
}