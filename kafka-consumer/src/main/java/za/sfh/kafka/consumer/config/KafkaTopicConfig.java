package za.sfh.kafka.consumer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

     public static final String TOPIC_NAME = "demo-topic";
     public static final String JSON_TOPIC_NAME="demo-topic-json";

     @Bean
     public NewTopic javaDemoTopic() {
          return TopicBuilder.name(TOPIC_NAME)
                  .build();
     }

     @Bean
     public NewTopic javaDemoJsonTopic() {
          return TopicBuilder.name(JSON_TOPIC_NAME)
                  .build();
     }
}
