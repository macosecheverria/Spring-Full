package org.example.security.springsecurityupnpractica;

import org.example.security.springsecurityupnpractica.entities.PermissionEntity;
import org.example.security.springsecurityupnpractica.entities.RoleEntity;
import org.example.security.springsecurityupnpractica.entities.RoleEnum;
import org.example.security.springsecurityupnpractica.entities.UserEntity;
import org.example.security.springsecurityupnpractica.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Set;


@SpringBootApplication
public class SpringSecurityUpnPracticaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityUpnPracticaApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder){
        return args -> {

            PermissionEntity createPermission = PermissionEntity.builder()
                    .name("CREATED")
                    .build();

            PermissionEntity readPermission = PermissionEntity.builder()
                    .name("READ")
                    .build();

            PermissionEntity deletePermission = PermissionEntity.builder()
                    .name("DELETE")
                    .build();

            RoleEntity adminRole = RoleEntity.builder()
                    .roleEnum(RoleEnum.ADMIN)
                    .permissionList(Set.of(createPermission, readPermission))
                    .build();

            RoleEntity userRole =  RoleEntity.builder()
                    .roleEnum(RoleEnum.USER)
                    .permissionList(Set.of(readPermission))
                    .build();

            RoleEntity developerRole = RoleEntity.builder()
                    .roleEnum(RoleEnum.DEVELOPER)
                    .permissionList(Set.of(createPermission, readPermission, deletePermission))
                    .build();


            UserEntity userOne = UserEntity.builder()
                    .username("marcos")
                    .password(passwordEncoder.encode("1234"))
                    .roles(Set.of(developerRole))
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .build();

            UserEntity userTwo = UserEntity.builder()
                    .username("marquinho")
                    .password(passwordEncoder.encode("1234"))
                    .roles(Set.of(adminRole))
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .build();

            UserEntity userThree = UserEntity.builder()
                    .username("marco")
                    .password(passwordEncoder.encode("1234"))
                    .roles(Set.of(userRole))
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .build();


            //userRepository.saveAll(List.of(userOne, userTwo, userThree));
        };
    }
}
