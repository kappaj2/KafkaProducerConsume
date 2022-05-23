package za.sfh.kafka.consumer.consumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import za.sfh.kafka.dto.User;
import za.sfh.kafka.consumer.config.KafkaTopicConfig;

@Service
@AllArgsConstructor
@Slf4j
public class KafkaConsumer {

     @KafkaListener(topics = KafkaTopicConfig.TOPIC_NAME, groupId = "DEMO-GROUP-1")
     public void consumeMessages(String message) {
          log.info("Received message from topic [topic: {}, message: {}]", KafkaTopicConfig.TOPIC_NAME, message);
     }

     @KafkaListener(topics = KafkaTopicConfig.JSON_TOPIC_NAME, groupId = "DEMO-GROUP-1")
     public void consumeUserMessages(User user) {
          log.info("Received message from topic [topic: {}, user: {}]", KafkaTopicConfig.JSON_TOPIC_NAME, user);
     }
}
