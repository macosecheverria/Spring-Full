package org.example.springcloud.msvc.usuarios.services;

import lombok.RequiredArgsConstructor;
import org.example.springcloud.msvc.usuarios.clients.CourseClientRest;
import org.example.springcloud.msvc.usuarios.exceptions.EmailAlreadyExistException;
import org.example.springcloud.msvc.usuarios.exceptions.UserNotFoundException;
import org.example.springcloud.msvc.usuarios.models.dtos.CreateUserDto;
import org.example.springcloud.msvc.usuarios.models.dtos.UpdateUserDto;
import org.example.springcloud.msvc.usuarios.models.entities.User;
import org.example.springcloud.msvc.usuarios.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements  UserService {

    private final UserRepository userRepository;

    private CourseClientRest client;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User id not found"));
    }

    @Override
    @Transactional
    public User save(CreateUserDto createUserDto) {

        //if(this.byEmail(createUserDto.getEmail()).isPresent()) {
           // throw new EmailAlreadyExistException("Email already exist");
        //}

        if(this.existByEmail(createUserDto.getEmail())) {
            throw new EmailAlreadyExistException("Email already exist");
        }

        User newUser = User.builder()
                .name(createUserDto.getName())
                .email(createUserDto.getEmail())
                .password(createUserDto.getPassword())
                .build();

        return this.userRepository.save(newUser);
    }

    @Override
    @Transactional
    public User update(Long id, UpdateUserDto updateUserDto){
        User userUpdated = this.findById(id);

        if(this.byEmail(updateUserDto.getEmail()).isPresent()) {
            throw new EmailAlreadyExistException("Email already exist");
        }

        userUpdated.setName(updateUserDto.getName());
        userUpdated.setEmail(updateUserDto.getEmail());
        userUpdated.setPassword(updateUserDto.getPassword());

        this.userRepository.save(userUpdated);

        return userUpdated;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        User userId = this.findById(id);

        this.userRepository.deleteById(userId.getId());
        this.client.deleteCourseUserById(userId.getId());
    }

    @Override
    public List<User> findAllById(Iterable<Long> ids) {
        return this.userRepository.findAllById(ids);
    }

    // metodos privados
    private Optional<User> byEmail(String email){
        return this.userRepository.findByEmail(email);
    }

    private boolean existByEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }

}
