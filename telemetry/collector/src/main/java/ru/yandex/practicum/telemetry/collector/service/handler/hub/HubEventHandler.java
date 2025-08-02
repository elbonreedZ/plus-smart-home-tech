package ru.yandex.practicum.telemetry.collector.service.handler.hub;

import ru.yandex.practicum.telemetry.collector.model.hub.HubEvent;
import ru.yandex.practicum.telemetry.collector.model.hub.enumeration.HubEventType;

public interface HubEventHandler {
    HubEventType getMessageType();
    void handle(HubEvent event);
}
