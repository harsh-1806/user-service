package com.harsh.userService.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.harsh.userService.entities.UserInfo;
import com.harsh.userService.entities.UserInfoDto;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UserInfoDeserializer implements Deserializer<UserInfoDto> {
    @Override
    public UserInfoDto deserialize(String s, byte[] bytes) {
        UserInfoDto user = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            user = objectMapper.readValue(bytes, UserInfoDto.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return user;
    }
}
