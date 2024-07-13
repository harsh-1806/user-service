package com.harsh.userService.consumer;

import com.harsh.userService.entities.UserInfoDto;
import com.harsh.userService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceConsumer {
    private final UserService userService;

    @Autowired
    public AuthServiceConsumer(UserService userService) {
        this.userService = userService;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(UserInfoDto eventData) {
        try {
            // TODO : Make it transactional to handle **idempotency** and validate phoneNumber, email etc, can use redis distributed lock
            userService.createOrUpdateUser(eventData);
        }
        catch (Exception e) {
            throw new RuntimeException("Exception in AuthService Consumer");
        }
    }
}
