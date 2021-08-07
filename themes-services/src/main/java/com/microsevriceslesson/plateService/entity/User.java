package com.microsevriceslesson.plateService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.microsevriceslesson.plateService.security.AuthProvider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "email_verified")
    private Boolean emailVerified = false;

    @ManyToOne(targetEntity = Role.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(targetEntity = Plate.class, mappedBy = "user", orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Plate> plates;

    @JsonIgnore
    private String password;

    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    @Column(name = "image_url")
    private String imageUrl;

    @Transient
    private String providerId;
}

