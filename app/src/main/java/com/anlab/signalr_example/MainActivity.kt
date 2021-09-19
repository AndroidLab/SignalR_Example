package com.anlab.signalr_example

import android.os.Bundle
import android.widget.Toast

class MainActivity : BaseActivity() {

    /**
     * Список подписок на ресурсы.
     */
    private val resourceSubscriptions = listOf(
        ResourceSubscriptionModel("/something1/data/somethingData") {
            //Делаем что то, при получении события от первого ресурса.
        },
        ResourceSubscriptionModel("/something2/data/somethingData") {
            //Делаем что то, при получении события от второго ресурса.
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        setSignalRSubscriptions(resourceSubscriptions)
    }
}