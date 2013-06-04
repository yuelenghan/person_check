package com.my.service.impl;

import com.my.dao.PersonDao;
import com.my.model.Person;
import com.my.service.PersonManager;
import com.my.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("personManager")
@WebService(serviceName = "PersonService", endpointInterface = "com.my.service.PersonManager")
public class PersonManagerImpl extends GenericManagerImpl<Person, Long> implements PersonManager {
    PersonDao personDao;

    @Autowired
    public PersonManagerImpl(PersonDao personDao) {
        super(personDao);
        this.personDao = personDao;
    }
}