package com.anlab.signalr_example

import androidx.appcompat.app.AppCompatActivity

/**
 * Представляет базовый класс Activity
 */
abstract class BaseActivity : AppCompatActivity() {

    /**
     * Сервис подписок на ресурсы.
     */
    private val _signalRService = SignalRApplication.application.signalRService

    /**
     * Лист подписок.
     */
    private val _resourceSubscriptions: MutableList<ResourceSubscriptionModel> = mutableListOf()

    override fun onStop() {
        super.onStop()
        _signalRService.unsubscribe(_resourceSubscriptions)
    }

    /**
     * Устанавливает подписки на ресурсы.
     * @param resourceSubscriptions Лист подписок.
     */
    fun setSignalRSubscriptions(
        resourceSubscriptions: List<ResourceSubscriptionModel>
    ) {
        _resourceSubscriptions.addAll(resourceSubscriptions)
        _signalRService.subscribe(resourceSubscriptions)
    }
}