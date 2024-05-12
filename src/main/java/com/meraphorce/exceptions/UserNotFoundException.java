package com.meraphorce.exceptions;

import java.lang.RuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus( HttpStatus.BAD_REQUEST )
public class UserNotFoundException extends RuntimeException {
	
    private Integer userId;

    public UserNotFoundException(Integer userId) {
        super("The user with id " + userId+ " was not found");
        this.userId = userId;
    }

    public Integer getUserId(){
        return userId;
    }

}
