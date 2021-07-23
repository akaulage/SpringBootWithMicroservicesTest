package com.akaulage.userservice.repository;

import com.akaulage.userservice.CommonDTO.ResponseTemplate;
import com.akaulage.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    ResponseTemplate findByUserId(Long userId);
}
