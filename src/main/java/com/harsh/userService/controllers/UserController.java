package com.harsh.userService.controllers;

import com.harsh.userService.entities.UserInfoDto;
import com.harsh.userService.services.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/v1")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserInfoDto> createUpdate(
            @RequestBody
            UserInfoDto userInfoDto
    ) {
        try {
            UserInfoDto user = userService.createOrUpdateUser(userInfoDto);
            return ResponseEntity.ok(user);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserInfoDto> getUser(
            @PathVariable(value = "id")
            String userId
    ) {
        try {
            UserInfoDto userInfoDto = userService.getUserByUserId(userId);
            return ResponseEntity.ok(userInfoDto);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
