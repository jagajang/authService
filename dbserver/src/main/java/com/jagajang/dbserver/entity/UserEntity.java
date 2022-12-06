package com.jagajang.dbserver.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Getter
@Table(name = "users", indexes = {
        @Index(name = "idx_email", columnList = "email"),
        @Index(name = "idx_role_email", columnList = "role, email"),
        @Index(name = "idx_nickname", columnList = "nickname")
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long uid;

    /**
     * maximum email length :
     * (64char)@(255char)
     * 64 + 1 + 255 = 320
     * Reference : RFC 3696
     */
    @Column(nullable = false, unique = true, length = 320)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 5)
    private String role;

    @Column(nullable = false, length = 20)
    private String nickname;

    @Column
    @Setter
    private Timestamp lastLogin;

    @Builder
    public UserEntity(
            String email,
            String password,
            String role,
            String nickname) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.nickname = nickname;
    }
}
