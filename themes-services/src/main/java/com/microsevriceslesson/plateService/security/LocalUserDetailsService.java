package com.microsevriceslesson.plateService.security;

import com.microsevriceslesson.plateService.repository.UserRepository;
import com.microsevriceslesson.plateService.security.oauth2.user.LocalUser;
import com.microsevriceslesson.plateService.entity.User;
import com.microsevriceslesson.plateService.exception.ResourceNotFoundException;
import com.microsevriceslesson.plateService.service.interfaces.UserService;
import com.microsevriceslesson.plateService.util.GeneralUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service("localUserDetailsService")
@RequiredArgsConstructor
public class LocalUserDetailsService implements UserDetailsService {

    private final UserService userService;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public LocalUser loadUserByUsername(final String email) throws UsernameNotFoundException {
        User user = userService.getByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User " + email + " was not found in the database");
        }
        return createLocalUser(user);
    }

    @Transactional
    public LocalUser loadUserById(Long id) {
        User user = userRepository.findByUserId(id);
        if (user == null) {
            throw new ResourceNotFoundException("User", "id", id);
        }
        return createLocalUser(user);
    }

    private LocalUser createLocalUser(User user) {
        return LocalUser.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .role(user.getUserRole())
                .user(user)
                .build();
    }
}
