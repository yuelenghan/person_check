package com.my.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.my.dao.PersonDao;
import com.my.model.Person;
import com.my.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonManagerImplTest extends BaseManagerMockTestCase {
    private PersonManagerImpl manager = null;
    private PersonDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(PersonDao.class);
        manager = new PersonManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetPerson() {
        log.debug("testing get...");

        final Long id = 7L;
        final Person person = new Person();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(id)));
            will(returnValue(person));
        }});

        Person result = manager.get(id);
        assertSame(person, result);
    }

    @Test
    public void testGetPersons() {
        log.debug("testing getAll...");

        final List persons = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(persons));
        }});

        List result = manager.getAll();
        assertSame(persons, result);
    }

    @Test
    public void testSavePerson() {
        log.debug("testing save...");

        final Person person = new Person();
        // enter all required fields
        person.setIdCard("TyWrAaEgGzElYdScJbZk");
        person.setIfBeon(Boolean.FALSE);
        person.setIfPic(Boolean.FALSE);
        person.setName("XaPmLmMrKyYrPlUyVoKwUsRcAyLkKoAeToBnPiLuEzAxOmUwJdJeHsDeEuCwQdPlMrOjJtCoYhHsHoTeNvCrTkSlRuCcPcMhAqWqLvDdHvXaMoApRsWsQiPcGzPeExRxNiQyZmNeZaZfBmVhGjFkRtFzOoWpHgPuYvIpJsHgFrKsUaYzWuSrSwStZuNwFjDiPrKiIjQv");
        person.setNormalTime(1L);
        person.setSex("Hy");
        person.setSpecType(Boolean.FALSE);
        person.setWorkCard("XcOqZkLvSyZsFrTgAbOlQxWrBcCiJeVjRfLuRsVvIbBgGyMmPmGlOrMeGbKgPqGaSkHgGbTcXfMzQtTwPpUeAhLzIkAeEdTmIrXrMlRxOrCsKmGjDdCuMnIkGeTbRnZtMmBgXnHaGdMaHyZxVcYiUfYlSoDgJiRiZwWyLkLxOyOkJxDmXgCiFmMnDnVcWuLuExExVdGx");
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(person)));
        }});

        manager.save(person);
    }

    @Test
    public void testRemovePerson() {
        log.debug("testing remove...");

        final Long id = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(id)));
        }});

        manager.remove(id);
    }
}