package com.demo.shop._01_users;

import com.demo.shop._01_users.models.LoginReqDTO;
import com.demo.shop._01_users.models.SignupReqDTO;
import com.demo.shop._01_users.models.UpdateUserInfoReqDTO;
import com.demo.shop.entities.User;
import org.springframework.stereotype.Component;


@Component
public class UserService {
    private final UserRepo userRepo;
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public int registerUser(SignupReqDTO signupReq) {

        User isExist = userRepo.findByHp(signupReq.getHp());
        if(isExist!=null) {
            throw new RuntimeException("이미 가입한 회원 연락처 입니다");
        }
        User user = User.builder()
                .name(signupReq.getName())
                .hp(signupReq.getHp())
                .adress(signupReq.getAddress())
                .zipCode(signupReq.getZipCode())
                .build();

        return userRepo.save(user).getId();
    }

    public User findUserDetail(int id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("유저가 존재하지 않습니다."));
    }

    public User login(LoginReqDTO loginReq) {
        User user =  userRepo.findByHpAndName(loginReq.getHp(),loginReq.getName());
        if (user == null) {
            throw new RuntimeException("유저가 존재하지 않습니다.");
        } else {
            return user;
        }
    }

    public int updateUserInfo(UpdateUserInfoReqDTO updateUserInfoReq) {
        User user = User.builder()
                .id(updateUserInfoReq.getId())
                .name(updateUserInfoReq.getName())
                .hp(updateUserInfoReq.getHp())
                .adress(updateUserInfoReq.getAddress())
                .zipCode(updateUserInfoReq.getZipCode())
                .build();
        return userRepo.save(user).getId();
    }

    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }
}
