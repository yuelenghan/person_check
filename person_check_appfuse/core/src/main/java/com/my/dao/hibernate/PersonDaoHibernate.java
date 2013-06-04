package com.my.dao.hibernate;

import com.my.model.Person;
import com.my.dao.PersonDao;
import com.my.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("personDao")
public class PersonDaoHibernate extends GenericDaoHibernate<Person, Long> implements PersonDao {

    public PersonDaoHibernate() {
        super(Person.class);
    }
}
