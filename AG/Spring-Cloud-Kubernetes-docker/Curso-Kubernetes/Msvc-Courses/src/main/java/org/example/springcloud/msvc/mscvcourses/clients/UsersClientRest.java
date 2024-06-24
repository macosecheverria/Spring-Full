package org.example.springcloud.msvc.mscvcourses.clients;

import org.example.springcloud.msvc.mscvcourses.models.pojos.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "msvc-users", url = "${msvc.users.url}")
public interface UsersClientRest {

    @GetMapping("/api/users/{id}")
    User findById(@PathVariable Long id);

    @PostMapping("/api/users")
    User create(@RequestBody  User user);

    @GetMapping("/api/users/users-by-courses")
    List<User> findAllById(@RequestParam List<Long> ids);

}
