package org.example.springcloud.msvc.usuarios.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.springcloud.msvc.usuarios.models.dtos.CreateUserDto;
import org.example.springcloud.msvc.usuarios.models.dtos.UpdateUserDto;
import org.example.springcloud.msvc.usuarios.models.entities.User;
import org.example.springcloud.msvc.usuarios.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(this.userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return ResponseEntity.ok(this.userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> save(@Valid @RequestBody CreateUserDto createUserDto){
        return ResponseEntity.status(201).body(this.userService.save(createUserDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(
            @PathVariable Long id, @Valid @RequestBody UpdateUserDto updateUserDto){
        User userUpdated =  this.userService.update(id, updateUserDto);
        return ResponseEntity.ok(userUpdated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        this.userService.deleteById(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    @GetMapping("/users-by-courses")
    public ResponseEntity<List<User>> findAllById(@RequestParam List<Long> ids){
        List<User> allUsersById = this.userService.findAllById(ids);
        return ResponseEntity.ok(allUsersById);
    }
}
