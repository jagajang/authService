package com.jagajang.dbserver.dao;

import com.jagajang.dbserver.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity existsUserEntityByEmail(String email);
    UserEntity findByEmail(String email);
    List<UserEntity> findAllByNickname(String nickname);
}
