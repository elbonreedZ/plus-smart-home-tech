package ru.yandex.practicum.telemetry.collector.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum KafkaTopic {
    TELEMETRY_SENSORS_V1("telemetry.sensors.v1"),
    TELEMETRY_SNAPSHOTS_V1("telemetry.snapshots.v1"),
    TELEMETRY_HUBS_V1("telemetry.hubs.v1");

    private final String topicName;
}

