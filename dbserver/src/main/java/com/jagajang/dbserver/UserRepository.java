package com.jagajang.dbserver;

import com.jagajang.dbserver.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Long, UserEntity> {
    UserEntity findByEmail(String email);

}
