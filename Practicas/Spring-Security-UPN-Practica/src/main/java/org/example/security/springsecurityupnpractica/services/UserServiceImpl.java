package org.example.security.springsecurityupnpractica.services;

import lombok.RequiredArgsConstructor;
import org.example.security.springsecurityupnpractica.dtos.AuthCreateUserRequest;
import org.example.security.springsecurityupnpractica.dtos.AuthLoginRequest;
import org.example.security.springsecurityupnpractica.dtos.AuthResponseCreate;
import org.example.security.springsecurityupnpractica.dtos.AuthResponseLogin;
import org.example.security.springsecurityupnpractica.entities.RoleEntity;
import org.example.security.springsecurityupnpractica.entities.UserEntity;
import org.example.security.springsecurityupnpractica.interfaces.UserServices;
import org.example.security.springsecurityupnpractica.repositories.RoleRepository;
import org.example.security.springsecurityupnpractica.repositories.UserRepository;
import org.example.security.springsecurityupnpractica.utils.JwtUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServices {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserDetailServiceImpl userDetailService;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtils jwtUtils;

    @Override
    @Transactional
    public AuthResponseCreate createUser(AuthCreateUserRequest authCreateUserRequest) {
        String username =  authCreateUserRequest.username();
        String password =  authCreateUserRequest.password();
        List<String> rolesRequest = authCreateUserRequest.roleRequest().roleList();

        Set<RoleEntity> roleEntityList = new HashSet<>(this.roleRepository
                .findRoleEntitiesByRoleEnumIn(rolesRequest));

        if(roleEntityList.isEmpty()){
            throw new BadCredentialsException("The roles specified does not exist");
        }

        UserEntity user = UserEntity.builder()
                .username(username)
                .password(password)
                .roles(roleEntityList)
                .isEnabled(true)
                .accountNoLocked(true)
                .accountNoExpired(true)
                .credentialNoExpired(true)
                .build();

        UserEntity userCreated = this.userRepository.save(user);

        return new AuthResponseCreate(
                userCreated.getUsername(),
                "User Created Succesfully",
                true);
    }

    @Override
    @Transactional(readOnly = true)
    public AuthResponseLogin loginUser(AuthLoginRequest authLoginRequest) {
        String username = authLoginRequest.username();
        String password = authLoginRequest.password();

        Authentication authentication = this.authenticate(username, password);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = this.jwtUtils.createToken(authentication);

        return new AuthResponseLogin(
                username,
                jwt
        );

    }

    private Authentication authenticate(String username, String password){

        UserDetails userDetails = this.userDetailService.loadUserByUsername(username);

        if(userDetails == null){
            throw  new BadCredentialsException("Invalid username or password");
        }

        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            throw new BadCredentialsException("Invalid Password");
        }

        return  new UsernamePasswordAuthenticationToken(
          username,
          userDetails.getPassword(),
          userDetails.getAuthorities()
        );

    }
}
