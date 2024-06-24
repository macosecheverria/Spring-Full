package com.marcos.springboot.backend.backend.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.marcos.springboot.backend.backend.models.Users;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    private List<Users> data;

    public UserRepositoryImpl(){
        this.data = List.of(
            new Users(1L , "Marcos", "Marquinho", "marcosTest@gmail.com"),
            new Users(2L, "Selva", "RoseMary", "selvaTest@gmail.com"),
            new Users(3L, "Juan", "Sebas", "juanTest@gmail.com")
        );
    }

    @Override
    public List<Users> findAll(){
        return data;
    }

    @Override
    public Users findById(Long id){
        return data.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

}
