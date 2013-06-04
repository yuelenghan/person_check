package com.my.dao;

import com.my.dao.BaseDaoTestCase;
import com.my.model.Person;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.NotTransactional;
import org.springframework.test.annotation.ExpectedException;

import java.util.List;

public class PersonDaoTest extends BaseDaoTestCase {
    @Autowired
    private PersonDao personDao;

    @Test
    @ExpectedException(DataAccessException.class)
    public void testAddAndRemovePerson() {
        Person person = new Person();

        // enter all required fields
        person.setIdCard("SxLyGzHzHpYuQgVcCrTx");
        person.setIfBeon(Boolean.FALSE);
        person.setIfPic(Boolean.FALSE);
        person.setName("QkPvHeOzNjXoYzLmFnFtSxAkYzDcTaUhKeFbWnXuWqYiHtKeMvGzWnFzZfGiNxSdZzPtUjZaKnZzHuRkAuBwStWcCvUaLuJeQxYmKlAkLrGcXiQqMzGyKsHrWlIpDxJaPxVjPyGcRfBlJlDdVyQiSsCsFnXpLlLqDsCrXmXrAfAoHwKqIsPrElZaEmCsEoRtCcXuMbPo");
        person.setNormalTime(4L);
        person.setSex("Tm");
        person.setSpecType(Boolean.FALSE);
        person.setWorkCard("MgPcUjPyEbSoAqPsIeZqUqChOjGsPvCfUeHwNyBaCeJqGsOlCpTwTySpMgXmAoCkYmHnQdDtZfKkRtPhVjAoSpVnTcXrMqAuPdMnSwThBaMkKiVjPaOtFaGeYmAeJrIeRzBkLcRwQqMfWvXbGtZgCzDmJsMkPoWdDnMrZbLoAxMtVuQiAoNiStQwKoGcGvMwHvCbNuNu");

        log.debug("adding person...");
        person = personDao.save(person);

        person = personDao.get(person.getId());

        assertNotNull(person.getId());

        log.debug("removing person...");

        personDao.remove(person.getId());

        // should throw DataAccessException 
        personDao.get(person.getId());
    }
}