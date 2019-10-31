package com.bdn.spring.repos;

import com.bdn.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <User,Long>{
    User findByUsername(String username);

    User findByActivationCode(String code);
}
