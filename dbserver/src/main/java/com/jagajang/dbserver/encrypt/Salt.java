package com.jagajang.dbserver.encrypt;

import com.jagajang.dbserver.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Salt {
    @Autowired
    private UserRepository userRepository;

    public String getSalt(String email) {
        return "";
    }
}
