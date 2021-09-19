package com.anlab.signalr_example

import com.google.gson.internal.LinkedTreeMap
import com.microsoft.signalr.HubConnectionState

/**
 * Описывает реализацию слушателя внешних событий.
 */
interface ISignalRListener {
    /**
     * Возвращает id подключения к SignalR.
     */
    val connectionId: String?

    /**
     * Возвращает статус подключения к SignalR.
     */
    val connectionState: HubConnectionState

    /**
     * Выполняет подключение к серверу SignalR.
     */
    fun startConnection()

    /**
     * Выполняет отключение от сервера SignalR.
     */
    fun stopConnection()

    /**
     * Подписывается на событие.
     * @param eventName Имя события.
     * @param handler Обработчик события.
     */
    fun subscribe(eventName: String, handler: (LinkedTreeMap<String, String>) -> Unit)

    /**
     * Отписывается от события.
     * @param eventName Имя события.
     */
    fun unsubscribe(eventName: String)
}