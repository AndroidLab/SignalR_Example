package com.anlab.signalr_example

/**
 * Представляет подписку на ресурс.
 */
data class ResourceSubscriptionModel(
    /**
     * Имя ресурса для отслеживания событий.
     */
    val resourceName: String,
    /**
     * Метод выполняемый при получении события.
     */
    val callback: () -> Unit
)