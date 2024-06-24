package org.example.security.springsecurityupnpractica.interfaces;

import org.example.security.springsecurityupnpractica.dtos.AuthCreateUserRequest;
import org.example.security.springsecurityupnpractica.dtos.AuthLoginRequest;
import org.example.security.springsecurityupnpractica.dtos.AuthResponseCreate;
import org.example.security.springsecurityupnpractica.dtos.AuthResponseLogin;

public interface UserServices {

    AuthResponseCreate createUser(AuthCreateUserRequest authCreateUserRequest);

    AuthResponseLogin loginUser(AuthLoginRequest authLoginRequest);


}
