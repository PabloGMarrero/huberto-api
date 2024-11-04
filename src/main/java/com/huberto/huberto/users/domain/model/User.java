package com.huberto.huberto.users.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)

@Entity
@Table(name = "users", indexes = {@Index(name = "uk_user_id", unique = true, columnList = "id")})
public class User {
    @Id
    @Column(name = "id", columnDefinition = "BINARY(16)")
    @UuidGenerator
    private UUID id;

    @Column(name = "created", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime created;

    @Column(name = "last_login", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime lastLogin;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    /*@Builder.Default
    @OneToMany(fetch = FetchType.LAZY, mappedBy="user", orphanRemoval = true)
    @OrderBy("created")
    private Set<Phone> phones = new HashSet<>();*/

    @Version
    @Column(name = "version", columnDefinition = "BIGINT DEFAULT 1")
    private Long version;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
}
