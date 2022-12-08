package com.jagajang.dbserver;

import com.jagajang.dbserver.dao.UserRepository;
import com.jagajang.dbserver.dao.entity.UserEntity;
import com.jagajang.dbserver.type.dto.UserMailPass;
import com.jagajang.dbserver.type.dto.UserMailPassName;
import com.jagajang.dbserver.type.dto.UserResponseInfo;
import com.jagajang.dbserver.type.enums.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DBService {
    @Autowired
    private UserRepository userRepository;

    public Boolean registerUser(UserMailPassName userInfoName) {
        if(userRepository.existsByEmail(userInfoName.getEmail())) {
            return false;
        }

        userRepository.save(new UserEntity(userInfoName));
        return true;
    }

    public List<UserResponseInfo> findUsersByNickname(String userName) {
        return userRepository
                .findAllByNickname(userName).stream()
                .map(userEntity ->
                        UserResponseInfo.builder()
                                .email(userEntity.getEmail())
                                .nickname(userEntity.getNickname())
                                .lastLogin(userEntity.getLastLogin())
                                .build()
                ).toList();
    }

    public UserRole validUser(UserMailPass userInfo) {
        UserEntity foundUser = userRepository.findByEmail(userInfo.getEmail());

        if(foundUser != null
                && userInfo.getPassword() == foundUser.getPassword()) {
            return foundUser.getRole();
        }

        return UserRole.GUEST;
    }
}
