package za.sfh.kafka.producer.producer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import za.sfh.kafka.dto.User;

import static za.sfh.kafka.producer.config.KafkaTopicConfig.JSON_TOPIC_NAME;
import static za.sfh.kafka.producer.config.KafkaTopicConfig.TOPIC_NAME;

@Service
@AllArgsConstructor
@Slf4j
public class KafkaProducer {

     private final KafkaTemplate<String, String> kafkaTemplate;
     private final KafkaTemplate<String, User> userKafkaTemplate;

     public void submitMessage(String message) {
          log.info("Submitting topic message [topic: {}, message: {}]", TOPIC_NAME, message);
          kafkaTemplate.send(TOPIC_NAME, message);
     }

     public void submitUser(User user) {
          log.info("Submitting topic message [topic: {}, user: {}]", TOPIC_NAME, user);
          Message<User> message = MessageBuilder.withPayload(user)
                  .setHeader(KafkaHeaders.TOPIC, JSON_TOPIC_NAME)
                  .build();
          userKafkaTemplate.send(message);
     }
}
