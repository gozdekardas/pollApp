package com.pollapp.pollApp.user.service;

import com.pollapp.pollApp.responses.model.Response;
import com.pollapp.pollApp.user.model.User;
import com.pollapp.pollApp.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repo;
    public List<User> listAllUsers() {
        return repo.findAll();
    }


    public List<User> queryUser(String userName, String password) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll()
                .withMatcher("userName", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("password", ExampleMatcher.GenericPropertyMatchers.exact());

        User userQuery = new User();
        userQuery.setUserName(userName);
        userQuery.setPassword(password);

        return repo.findAll(Example.of(userQuery, exampleMatcher));

    }

    public List<User> findByUserName (String userName) {
        return repo.findByUserName(userName);
    }
}
