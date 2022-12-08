package com.authserver.mainserver.home.service;

import com.authserver.mainserver.api.db.DBWebClientService;
import com.authserver.mainserver.type.dto.UserMailName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    @Autowired
    DBWebClientService dbWebClientService;

    public List<UserMailName> searchUsersWithEmail(String email) {
        return null;
    }

    public List<UserMailName> searchUsersWithNickname(String nickname) {
        dbWebClientService.searchUser(nickname);
        return null;
    }
}
