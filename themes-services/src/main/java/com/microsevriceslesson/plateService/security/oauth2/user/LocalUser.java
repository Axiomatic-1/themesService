package com.microsevriceslesson.plateService.security.oauth2.user;

import com.microsevriceslesson.plateService.util.GeneralUtils;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LocalUser extends User implements OAuth2User, OidcUser {

    private final OidcIdToken idToken;
    private final OidcUserInfo userInfo;
    private Map<String, Object> attributes;
    private com.microsevriceslesson.plateService.entity.User user;

    public LocalUser(String userID,
                     String password,
                     boolean enabled,
                     boolean accountNonExpired,
                     boolean credentialsNonExpired,
                     boolean accountNonLocked,
                     Collection<? extends GrantedAuthority> authorities,
                     com.microsevriceslesson.plateService.entity.User user) {
        this(userID, password, enabled, accountNonExpired, credentialsNonExpired,
                accountNonLocked, authorities, user, null, null);
    }

    public LocalUser(String userID,
                     String password,
                     boolean enabled,
                     boolean accountNonExpired,
                     boolean credentialsNonExpired,
                     boolean accountNonLocked,
                     Collection<? extends GrantedAuthority> authorities,
                     com.microsevriceslesson.plateService.entity.User user,
                     OidcIdToken idToken,
                     OidcUserInfo userInfo) {
        super(userID, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.user = user;
        this.idToken = idToken;
        this.userInfo = userInfo;
    }

    public static LocalUser create(com.microsevriceslesson.plateService.entity.User user,
                                   Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo) {
        LocalUser localUser = new LocalUser(user.getEmail(), user.getPassword(), user.isEnabled(),
                true, true, true,
                GeneralUtils.buildSimpleGrantedAuthorities(Set.of(user.getUserRole())),
                user, idToken, userInfo);

        localUser.setAttributes(attributes);

        return localUser;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getName() {
        return this.user.getDisplayName();
    }

    @Override
    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    @Override
    public Map<String, Object> getClaims() {
        return this.attributes;
    }

    @Override
    public OidcUserInfo getUserInfo() {
        return this.userInfo;
    }

    @Override
    public OidcIdToken getIdToken() {
        return this.idToken;
    }

    public com.microsevriceslesson.plateService.entity.User getUser() {
        return user;
    }
}
