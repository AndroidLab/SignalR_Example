package com.anlab.signalr_example

import android.app.Application
import java.security.SecureRandom
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager

/**
 * Представляет приложение.
 */
class SignalRApplication : Application() {

    lateinit var signalRListener: ISignalRListener   // Слушатель внешних событий.
    lateinit var signalRService: ISignalRService   // Сервис подписок на ресурсы.

    companion object {
        lateinit var application: SignalRApplication
    }

    override fun onCreate() {
        super.onCreate()
        application = this

        // Модифицированный X509TrustManager для доверия всем сертификатам.
        val trustAllCerts = TrustAllCerts()
        // Модифицированный протокол безопасной передачи данных.
        val sslSocketFactory = SSLContext.getInstance("TLSv1.2").apply {
                init(null, arrayOf<TrustManager>(trustAllCerts), SecureRandom())
            }.socketFactory

        signalRListener = SignalRListener(sslSocketFactory, trustAllCerts)
        signalRService = SignalRService(signalRListener)
    }

}