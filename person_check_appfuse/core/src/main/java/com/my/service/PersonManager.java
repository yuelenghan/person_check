package com.my.service;

import com.my.service.GenericManager;
import com.my.model.Person;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface PersonManager extends GenericManager<Person, Long> {
    
}