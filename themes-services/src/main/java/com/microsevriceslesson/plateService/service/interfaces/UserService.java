package com.microsevriceslesson.plateService.service.interfaces;

import com.microsevriceslesson.plateService.security.oauth2.user.LocalUser;
import com.microsevriceslesson.plateService.controller.dto.SignUpRequest;
import com.microsevriceslesson.plateService.entity.User;
import com.microsevriceslesson.plateService.exception.UserAlreadyExistAuthenticationException;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;

import java.util.List;
import java.util.Map;

public interface UserService {

    User registerNewUser(SignUpRequest signUpRequest) throws UserAlreadyExistAuthenticationException;

    User update(User user);

    User findUserById(Long id);

    User findByEmail(String email);

    List<User> findAllUsers();

    LocalUser processUserRegistration(String registrationId, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo);
}
