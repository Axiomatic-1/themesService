//package com.microsevriceslesson.plateService.security;
//
//import com.microsevriceslesson.plateService.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.oauth2.jwt.Jwt;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
//
//import java.util.Collection;
//
//@RequiredArgsConstructor
//public class JwtGrantedAuthoritiesConverter extends JwtAuthenticationConverter {
//
//    private final UserService userService;
//
//    @Override
//    protected Collection<GrantedAuthority> extractAuthorities(Jwt jwt) {
//        Collection<GrantedAuthority> authorities = super.extractAuthorities(jwt);
//        String email = jwt.getClaims().get("email").toString();
//        String currentUserRoleName = getUserRoleName(email);
//        authorities.add(new SimpleGrantedAuthority(currentUserRoleName));
//        return authorities;
//    }
//
//    private String getUserRoleName(String corporateEmail) {
//        return userService.findByEmail(corporateEmail);
////                .getRole()
////                .getName();
//    }
//}