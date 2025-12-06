package com.demo.shop._01_users;

import com.demo.shop.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;

//당장은 쓰지 않는다(구조가 단순해서 별도의 계층을 두지 않아도 됨)
@Component
public class UserDao {
    //UserRepo는 단일의 고유 bean이므로 별도의 binding이 없더라도 autoWired인듯 하다
    private final UserRepo userRepo;

    public UserDao(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUser () {
        return userRepo.findAll();
    }
}
