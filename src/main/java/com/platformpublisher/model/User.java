package com.platformpublisher.model;

import com.platformpublisher.enums.UserType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(of = "id") @ToString(exclude = "password")
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.PROTECTED)
    private Long id;

    @Column(name = "full_name") private String fullName;

    @Column(name = "name_user") private String nameUser;

    private String email;

    @Getter(value = AccessLevel.NONE) private String password;

    @Column(name = "created_at") private LocalDate createdAt;

    @Column(name = "account_activity") @Enumerated(EnumType.ORDINAL)
    private UserType accountActivity;

    @Column(name = "linked_in") private String linkedIn;

    private String github;
}