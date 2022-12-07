package com.jagajang.dbserver;

import com.jagajang.dbserver.dao.UserRepository;
import com.jagajang.dbserver.dao.entity.UserEntity;
import com.jagajang.dbserver.type.dto.UserMailPassName;
import com.jagajang.dbserver.type.dto.UserResponseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DBService {
    @Autowired
    private UserRepository userRepository;

    public Boolean registerUser(UserMailPassName userInfoName) {
        if(userRepository.existsByEmail(userInfoName.getEmail()))
            return false;
        userRepository.save(new UserEntity(userInfoName));
        log.info(userRepository.findByEmail(userInfoName.getEmail()).getNickname());
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
}
