package com.andres.springboot.app.springbootcrud.presentacion.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andres.springboot.app.springbootcrud.domain.entities.Role;
import com.andres.springboot.app.springbootcrud.domain.entities.User;
import com.andres.springboot.app.springbootcrud.domain.interfaces.UserService;
import com.andres.springboot.app.springbootcrud.domain.repositories.RoleRepository;
import com.andres.springboot.app.springbootcrud.domain.repositories.UserRepository;


@Service("userService")
public class UserServiceImpl implements UserService {

    private  UserRepository userRepository;

    private  RoleRepository roleRepository;

    private  PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {

        Optional<Role> existeRoleUser = this.roleRepository.findByName("ROLE_USER");

        List<Role> roles = new ArrayList<>();

        existeRoleUser.ifPresent(roles::add);
        if (user.isAdmin()) {
            Optional<Role> existRoleAdmin = this.roleRepository.findByName("ROLE_ADMIN");

            existRoleAdmin.ifPresent(roles::add);
        }

        user.setRoles(roles);
        user.setRoles(List.of(new Role("ROLE_USER")));

        user.setPassword(this.passwordEncoder.encode(user.getPassword()));

        User userCreated = this.userRepository.save(user);

        return userCreated;
    }

    @Override
    public boolean existsByUsername(String username){
        return this.userRepository.existsByUsername(username);
    }

}
