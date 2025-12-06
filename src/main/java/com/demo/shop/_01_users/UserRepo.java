package com.demo.shop._01_users;

import com.demo.shop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

//JPA가 주요 쿼리메서드를 알아서 구현 해준다
public interface UserRepo extends JpaRepository<User, Integer> {
    
    //이름을 분석해서 JPA가 쿼리를 만들어준다
    User findByHp(String hp);

    User findByHpAndName(String hp, String name);
}
