package com.demo.shop.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //default로그인 화면 off
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        //회원가입은 open, 그 외는 모두 닫음
                        .requestMatchers(HttpMethod.POST, "/user").permitAll()
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/swagger-ui.html"
                        ).permitAll()
                        .requestMatchers("/login", "/error").permitAll()
                        // 🔹 2) GET /users/** → 로그인 필요
                        .requestMatchers(HttpMethod.GET, "/user/**").authenticated()
                        // 🔹 3) 그 외는 적당히 규칙 추가

                        .anyRequest().authenticated()

                )

                // 🔹 기본 로그인 폼 그대로 사용
                .formLogin(form -> form
                        .loginProcessingUrl("/login")// [post]/login
                        .usernameParameter("hp")      // id -> hp
                        .passwordParameter("name")    // pw -> name
                        .successHandler((request, response, authentication) -> {
                            // 성공은 200
                            response.setStatus(HttpStatus.OK.value());
                            response.setContentType("application/json;charset=UTF-8");

                            var body = new java.util.HashMap<String, Object>();
                            body.put("message", "login success");
                            body.put("user", authentication.getName()); // hp

                            var mapper = new ObjectMapper();
                            response.getWriter().write(mapper.writeValueAsString(body));
                        })
                        .failureHandler((request, response, ex) -> {
                            // 실패시 401 처리
                            response.setStatus(HttpStatus.UNAUTHORIZED.value());
                            response.setContentType("application/json;charset=UTF-8");

                            var body = new java.util.HashMap<String, Object>();
                            body.put("message", "login failed");
                            body.put("reason", ex.getMessage());

                            var mapper = new ObjectMapper();
                            response.getWriter().write(mapper.writeValueAsString(body));
                        })
                        // .defaultSuccessUrl("/", true) // 로그인 성공 후 redirecr를 원한다면 사용
                        .permitAll()
                )

                .logout(logout -> logout.permitAll());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //문자 그대로 사용. 실제로는 암호화
        return NoOpPasswordEncoder.getInstance();
    }

}
