package org.example.springcloud.msvc.usuarios.exceptions;

public class EmailAlreadyExistException extends  RuntimeException{
    public EmailAlreadyExistException(String message){
        super(message);
    }
}
