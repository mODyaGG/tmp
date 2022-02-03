package com.exemple.YPECProjectRESTServer.Contollers;

import org.springframework.http.HttpStatus;

import java.util.List;

public interface IController <T>{
    List<T> list();
    T getOne(T object);
    HttpStatus create(T object);
    T update(T objectFromDb, T requestObject);
    HttpStatus delete(T object);
}
