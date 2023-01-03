package com.balietek.exceptions;

public class UserAlreadyExistException extends Exception{

    public UserAlreadyExistException(){
        super();
    }

    public UserAlreadyExistException(String msge){
        super(msge);
    }
    
    public UserAlreadyExistException(String msge, Throwable t){
        super(msge,t);
    }
}
