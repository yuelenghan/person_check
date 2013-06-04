package com.my.dao;

import com.my.dao.GenericDao;

import com.my.model.Person;

/**
 * An interface that provides a data management interface to the Person table.
 */
public interface PersonDao extends GenericDao<Person, Long> {

}