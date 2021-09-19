package com.anlab.signalr_example

/**
 * Описывает методы подписки на внешние события.
 */
interface ISignalRService {
    /**
     * Добавляет ресурсы в подписку.
     * @param subscriptionsForAdd Список ресурсов для подписки.
     */
    fun subscribe(subscriptionsForAdd: List<ResourceSubscriptionModel>)

    /**
     * Удаляет ресурсы из подписки.
     * @param subscriptionsForRemove Список ресурсов для отписки.
     */
    fun unsubscribe(subscriptionsForRemove: List<ResourceSubscriptionModel>)
}