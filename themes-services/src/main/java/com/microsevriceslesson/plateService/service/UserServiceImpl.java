package com.microsevriceslesson.plateService.service;

import com.microsevriceslesson.plateService.security.oauth2.user.LocalUser;
import com.microsevriceslesson.plateService.controller.dto.SignUpRequest;
import com.microsevriceslesson.plateService.controller.dto.SocialProvider;
import com.microsevriceslesson.plateService.entity.Role;
import com.microsevriceslesson.plateService.entity.User;
import com.microsevriceslesson.plateService.exception.OAuth2AuthenticationProcessingException;
import com.microsevriceslesson.plateService.exception.UserAlreadyExistAuthenticationException;
import com.microsevriceslesson.plateService.repository.RoleRepository;
import com.microsevriceslesson.plateService.repository.UserRepository;
import com.microsevriceslesson.plateService.security.oauth2.user.OAuth2UserInfo;
import com.microsevriceslesson.plateService.security.oauth2.user.OAuth2UserInfoFactory;
import com.microsevriceslesson.plateService.service.interfaces.UserService;
import com.microsevriceslesson.plateService.util.GeneralUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public User registerNewUser(SignUpRequest signUpRequest) throws UserAlreadyExistAuthenticationException {
        if (signUpRequest.getUserID() != null && userRepository.existsById(signUpRequest.getUserID())) {
            throw new UserAlreadyExistAuthenticationException("User with User id " + signUpRequest.getUserID() + " already exist");
        } else if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new UserAlreadyExistAuthenticationException("User with email id " + signUpRequest.getEmail() + " already exist");
        }
        User newUser = User.builder()
                .userId(signUpRequest.getUserID())
                .providerUserId(signUpRequest.getProviderUserId())
                .displayName(signUpRequest.getDisplayName())
                .build();
        Role newUserRole = roleRepository.findByName("ROLE_USER");
        newUser.setPassword(signUpRequest.getPassword());
        newUser.setUserRole(newUserRole);
        newUser.setEmail(signUpRequest.getEmail());
        newUser.setCratedDate(LocalDate.now());
        newUser.setLastModifiedDate(LocalDate.now());
        newUser.setEnabled(true);
        newUser = userRepository.save(newUser);
        userRepository.flush();
        return newUser;
    }

    @Transactional
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @Transactional
    @Override
    public User findUserById(Long id){
        return userRepository.findByUserId(id);
    }

    @Transactional
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @Transactional
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }


    @Override
    @Transactional
    public LocalUser processUserRegistration(String registrationId, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo) {
        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(registrationId, attributes);
        if (StringUtils.isEmpty(oAuth2UserInfo.getName())) {
            throw new OAuth2AuthenticationProcessingException("Name not found from OAuth2 provider");
        } else if (StringUtils.isEmpty(oAuth2UserInfo.getEmail())) {
            throw new OAuth2AuthenticationProcessingException("Email not found from OAuth2 provider");
        }
        SignUpRequest userDetails = toUserRegistrationObject(registrationId, oAuth2UserInfo);
        User user = findByEmail(oAuth2UserInfo.getEmail());
        if (user != null) {
            if (!user.getDisplayName().equals(registrationId) && !user.getDisplayName().equals(SocialProvider.LOCAL.getProviderType())) {
                throw new OAuth2AuthenticationProcessingException(
                        "Looks like you're signed up with " + user.getProvider() + " account. Please use your " + user.getProvider() + " account to login.");
            }
            user = updateExistingUser(user, oAuth2UserInfo);
        } else {
            user = registerNewUser(userDetails);
        }

        return LocalUser.builder()
                .user(user)
                .attributes(attributes)
                .idToken(idToken)
                .userInfo(userInfo)
                .build();
    }

    private User updateExistingUser(User existingUser, OAuth2UserInfo oAuth2UserInfo) {
        existingUser.setDisplayName(oAuth2UserInfo.getName());
        existingUser.setEnabled(true);
        return userRepository.save(existingUser);
    }

    private SignUpRequest toUserRegistrationObject(String registrationId, OAuth2UserInfo oAuth2UserInfo) {
        return SignUpRequest.builder().providerUserId(oAuth2UserInfo.getId()).displayName(oAuth2UserInfo.getName()).email(oAuth2UserInfo.getEmail())
                .socialProvider(GeneralUtils.toSocialProvider(registrationId)).password("changeit").build();
    }

}