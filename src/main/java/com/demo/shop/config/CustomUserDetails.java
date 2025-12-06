package com.demo.shop.config;

import com.demo.shop.entities.User; // 네 엔티티 패키지에 맞춰 수정
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    // ✅ 여기서 "username" = hp로 사용할 거야
    @Override
    public String getUsername() {
        return user.getHp();
    }

    // ✅ 패스워드는 일단 user.getName() 을 password로 쓴다고 가정 (예제용)
    @Override
    public String getPassword() {
        return user.getName(); // 진짜 비밀번호 컬럼이 따로 있으면 거기로 변경
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 기본 ROLE_USER 정도만 쓰고 싶으면 이렇게
        return Collections.emptyList();
    }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }

    public User getUser() {
        return user;
    }
}
