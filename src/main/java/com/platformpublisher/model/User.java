package com.platformpublisher.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Builder
@Data
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(of = "id") @ToString(exclude = "password")
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.PROTECTED)
    private Long id;
    private String fullName;
    private String nameUser;
    private String email;
    @Getter(value = AccessLevel.NONE)
    private String password;
    private LocalDate createdAt;
    private Boolean accountActivity;
    private String linkedIn;
    private String github;
}