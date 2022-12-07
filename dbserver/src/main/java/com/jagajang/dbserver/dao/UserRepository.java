package com.jagajang.dbserver.dao;

import com.jagajang.dbserver.dto.UserInfoName;
import com.jagajang.dbserver.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByEmail(String email);
    UserEntity findByEmail(String email);
    List<UserEntity> findAllByNickname(String nickname);

    UserEntity save(UserEntity user);
}
