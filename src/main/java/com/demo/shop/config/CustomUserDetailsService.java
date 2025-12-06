package com.demo.shop.config;

import com.demo.shop.entities.User;
import com.demo.shop._01_users.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepo userRepository; // hp로 찾을 수 있어야 함

    @Override
    public UserDetails loadUserByUsername(String hp) throws UsernameNotFoundException {
        User user = userRepository.findByHp(hp);
        if (user == null) {
            throw new UsernameNotFoundException("해당 hp를 가진 유저가 없습니다: " + hp);
        }
        return new CustomUserDetails(user);
    }
}
