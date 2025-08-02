package ru.yandex.practicum.telemetry.collector.service.handler;

import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.telemetry.collector.utils.KafkaTopic;

import java.time.Duration;

@Component
@RequiredArgsConstructor
public class EventProducer {
    private final Producer<Void, SpecificRecordBase> producer;

    private void send(String topic, SpecificRecordBase event) {
        producer.send(new ProducerRecord<>(topic, null, event));
    }

    public void sendSensorEvent(SpecificRecordBase event) {
        send(KafkaTopic.TELEMETRY_SENSORS_V1.getTopicName(), event);
    }

    public void sendHubEvent(SpecificRecordBase event) {
        send(KafkaTopic.TELEMETRY_HUBS_V1.getTopicName(), event);
    }

    @PreDestroy
    public void stop() {
        producer.flush();
        producer.close(Duration.ofSeconds(30));
    }

}
