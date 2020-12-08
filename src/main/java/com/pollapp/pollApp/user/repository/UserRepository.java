package com.pollapp.pollApp.user.repository;

import com.pollapp.pollApp.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByUserName(String userName);


}

