package com.harsh.userService.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "users")
public class UserInfo {

    @Id
    @JsonProperty("user_id")
    @NonNull
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
}
