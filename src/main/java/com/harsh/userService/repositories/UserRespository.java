package com.harsh.userService.repositories;

import com.harsh.userService.entities.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRespository extends CrudRepository<UserInfo, String> {
    Optional<UserInfo> findById(String userId);
}
