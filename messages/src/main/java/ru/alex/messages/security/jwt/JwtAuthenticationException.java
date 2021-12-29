package ru.alex.messages.security.jwt;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

@Getter
public class JwtAuthenticationException extends AuthenticationException {

    private HttpStatus httpStatus;


    public JwtAuthenticationException(String msg, Throwable t){
        super(msg,t);
    }

    public JwtAuthenticationException(String msg) {
        super(msg);
    }

    public JwtAuthenticationException(String msg, HttpStatus httpStatus){
        super(msg);
        this.httpStatus = httpStatus;
    }
}