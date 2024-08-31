package com.harsh.userService.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfoDto {
    @JsonProperty("user_id")
    private String userId;

    @NonNull
    @JsonProperty("first_name")
    private String firstName;

    @NonNull
    @JsonProperty("last_name")
    private String lastName;
    @NonNull
    @JsonProperty("phone_number")
    private String phoneNumber;
    @NonNull
    @JsonProperty("email")
    private String email;
    @JsonProperty("profile_pic")
    private String profilePic;


    @JsonIgnore
    public UserInfo getUserInfo() {
        return UserInfo.builder()
                .firstName(firstName)
                .lastName(lastName)
                .userId(userId)
                .phoneNumber(phoneNumber)
                .email(email)
                .profilePic(profilePic)
                .build();
    }

}
