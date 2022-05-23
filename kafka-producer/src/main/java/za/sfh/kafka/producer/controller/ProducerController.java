package za.sfh.kafka.producer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.sfh.kafka.dto.User;
import za.sfh.kafka.producer.producer.KafkaProducer;

@RestController
@RequestMapping("/api/producer")
@AllArgsConstructor
public class ProducerController {

     private final KafkaProducer kafkaProducer;

     @GetMapping("/submit/string")
     public ResponseEntity<?> submitMessage(@RequestParam("message") String message) {
          kafkaProducer.submitMessage(message);
          return ResponseEntity.ok().build();
     }

     @PostMapping("/submit/user")
     public ResponseEntity<?> submitUser(@RequestBody User user) {
          kafkaProducer.submitUser(user);
          return ResponseEntity.ok().build();
     }
}
