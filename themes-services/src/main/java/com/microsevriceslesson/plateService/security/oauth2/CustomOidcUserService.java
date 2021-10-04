package com.microsevriceslesson.plateService.security.oauth2;

import com.microsevriceslesson.plateService.exception.OAuth2AuthenticationProcessingException;
import com.microsevriceslesson.plateService.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CustomOidcUserService extends OidcUserService {

    private final UserService userService;

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        OidcUser oidcUser = super.loadUser(userRequest);
        String provider = userRequest.getClientRegistration().getRegistrationId();
        Map<String, Object> attributes = new HashMap<>(oidcUser.getAttributes());
        try {
            return userService.processUserRegistration(provider, attributes, oidcUser.getIdToken(),
                    oidcUser.getUserInfo());
        } catch (AuthenticationException ex) {
            throw ex;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new OAuth2AuthenticationProcessingException(ex.getMessage(), ex.getCause());
        }
    }
}
