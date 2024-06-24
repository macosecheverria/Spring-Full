package com.andres.curso.springboot.error.springbooterror.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.andres.curso.springboot.error.springbooterror.models.domain.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("totalUsers")
    private List<User> users;

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();

        // User userId;
        // for (User us : users) {
        // if (us.getId().equals(id)) {
        // userId = us;
        // break;
        // }
        // }
        // return userId;
    }

}
