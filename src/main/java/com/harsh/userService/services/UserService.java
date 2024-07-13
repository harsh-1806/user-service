package com.harsh.userService.services;

import com.harsh.userService.entities.UserInfo;
import com.harsh.userService.entities.UserInfoDto;
import com.harsh.userService.repositories.UserRespository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class UserService {
    private final UserRespository userRespository;

    public UserService(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    public UserInfoDto createOrUpdateUser(UserInfoDto userInfoDto) {
        // Todo : Implement Update logic
        Function<UserInfo, UserInfo> updatingUser = userRespository::save;

        Supplier<UserInfo> createUser = () -> {
            return userRespository.save(userInfoDto.getUserInfo());
        };

        UserInfo userInfo = userRespository.findById(userInfoDto.getUserId())
                .map(updatingUser)
                .orElseGet(createUser);

        return UserInfoDto.builder()
                .userId(userInfo.getUserId())
                .firstName(userInfo.getFirstName())
                .lastName(userInfo.getLastName())
                .email(userInfo.getEmail())
                .profilePic(userInfo.getProfilePic())
                .phoneNumber(userInfo.getPhoneNumber())
                .build();
    }

    public UserInfoDto getUserByUserId(String userId) throws Exception {
        Optional<UserInfo> userInfoOpt = userRespository.findById(userId);

        if(userInfoOpt.isEmpty()) {
            throw new Exception("User not found!");
        }

        UserInfo userInfo = userInfoOpt.get();

        return UserInfoDto.builder()
                .userId(userInfo.getUserId())
                .firstName(userInfo.getFirstName())
                .lastName(userInfo.getLastName())
                .phoneNumber(userInfo.getPhoneNumber())
                .email(userInfo.getEmail())
                .profilePic(userInfo.getProfilePic())
                .build();
    }
}
