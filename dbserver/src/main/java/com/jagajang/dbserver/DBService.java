package com.jagajang.dbserver;

import com.jagajang.dbserver.dao.UserRepository;
import com.jagajang.dbserver.dao.entity.UserEntity;
import com.jagajang.dbserver.dto.UserInfoName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DBService {
    @Autowired
    private UserRepository userRepository;

    public Boolean registerUser(UserInfoName userInfoName) {
        if(userRepository.existsByEmail(userInfoName.getEmail()))
            return false;
        userRepository.save(new UserEntity(userInfoName));
        log.info(userRepository.findByEmail(userInfoName.getEmail()).getNickname());
        return true;
    }

    /*public UserInfoName userInfo(String email) {
        return userRepository.findByEmail(email);
    }*/
}