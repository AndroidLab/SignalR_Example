package com.anlab.signalr_example

/**
 * Представляет реализацию подписок на ресурсы.
 */
class SignalRService (
    private val signalRListener: ISignalRListener
) : ISignalRService {
    /**
     * Возвращает или устанавливает подписку на ресурсы.
     */
    private val resourcesSubscriptions = mutableListOf<ResourceSubscriptionModel>()

    init {
        subscribeOnResourceChanged()
    }

    /**
     * Подписывается на события изменения ресурса.
     */
    private fun subscribeOnResourceChanged() {
        signalRListener.subscribe(
            "ResourceChangedEventOccurred"
        ) { event ->
            resourcesSubscriptions.forEach { subscription ->
                val resourceName = event["resourceName"]
                if (resourceName != null && resourceName.contains(subscription.resourceName)) {
                    //Реагируем на изменение ресурса.
                    subscription.callback()
                }
            }
        }
    }

    override fun subscribe(subscriptionsForAdd: List<ResourceSubscriptionModel>) {
        subscriptionsForAdd.forEach { resourceSubscription ->
            resourcesSubscriptions.add(resourceSubscription)
        }
    }

    override fun unsubscribe(subscriptionsForRemove: List<ResourceSubscriptionModel>) {
        subscriptionsForRemove.forEach { resourceSubscription ->
            resourcesSubscriptions.remove(resourceSubscription)
        }
    }
}