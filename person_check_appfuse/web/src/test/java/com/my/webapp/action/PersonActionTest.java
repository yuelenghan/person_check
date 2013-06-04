package com.my.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import com.my.service.PersonManager;
import com.my.model.Person;
import com.my.webapp.action.BaseActionTestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonActionTest extends BaseActionTestCase {
    private PersonAction action;

    @Before
    public void onSetUp() {
        super.onSetUp();

        action = new PersonAction();
        PersonManager personManager = (PersonManager) applicationContext.getBean("personManager");
        action.setPersonManager(personManager);

        // add a test person to the database
        Person person = new Person();

        // enter all required fields
        person.setIdCard("TcAuPvCaJxFcAySoPoEp");
        person.setIfBeon(Boolean.FALSE);
        person.setIfPic(Boolean.FALSE);
        person.setName("ZuWyTmPvAkUkTtHaJpHaAhTuXfEzFoCaYmFpAiFdFeRhLhPuGrRsGnPcBsQmBsIkLyUkCmQoJgTcPaKzWiZkDhNcIgBwYbHcHiNdRxOuZlSvNoRyIsGtCpLtCxCoIhRiKkMwIwNyXfMoUqDpCqDxNuTdPjBiKyRoYeIuNmVcIuTjEdLcSxXfPzWqWhZiXgJaApKpDrDg");
        person.setNormalTime(4L);
        person.setSex("Ap");
        person.setSpecType(Boolean.FALSE);
        person.setWorkCard("BcHaGgTcDjNjJmFsCzXjQiSpAfJpJwAkCyHoWjGdHbVyCyJrCeEaBgVuJtCzAvOaKvXmNfPiUoOsFbZoKbLiAfEqTbKkTyXiXuQvMhZfAjVfAuUlPoQqXaOeGcCvGrDrYuZiYpFzIpUxFaRcAcHdQyPbKdHjFsGzDjStPzEdHgQoUzUkCpPbSkWaVxVhBxAxLmBlDwZq");

        personManager.save(person);
    }

    @Test
    public void testGetAllPersons() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getPersons().size() >= 1);
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        PersonManager personManager = (PersonManager) applicationContext.getBean("personManager");
        personManager.reindex();

        action.setQ("*");
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertEquals(4, action.getPersons().size());
    }

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setId(-1L);
        assertNull(action.getPerson());
        assertEquals("success", action.edit());
        assertNotNull(action.getPerson());
        assertFalse(action.hasActionErrors());
    }

    @Test
    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setId(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getPerson());

        Person person = action.getPerson();
        // update required fields
        person.setIdCard("AxJpWqPhExVrPoLiMlBu");
        person.setIfBeon(Boolean.FALSE);
        person.setIfPic(Boolean.FALSE);
        person.setName("JgPeMfGhJgZbUjJrFjOuFiYvHsVpTxVmUhVkAjDoLqGbXyXsNaRgHqMsDzVgWzMuJtLwYtNmFqGcVnZvKdQyVdTqYqZkWaOuSiWuBzBrBqRoOjGzGjYxEcDoKbAxJcKdXtUrSoAcUnSxGuPlRdJwYgTdNoRxBmYlDgOdCaXzWaLaCfNtVwWrRvLuOwUdXkFrBcJqDnPh");
        person.setNormalTime(1L);
        person.setSex("Cm");
        person.setSpecType(Boolean.FALSE);
        person.setWorkCard("HlQaVlWiTsPtLdNnFdZmDcLxUqNkHiNyFdArLpDxAqGkVmUwGeFgEeJgUnYyHjVoZdEaTeToWgCzZfMrSuUxUmIwZhDkViLbSmWzIiDsIwWrSwPjPtLeWvTbXbScZzGaIhEwEgEgYpWoZiLmTlBkDvUqKlBeXgBoKgWiFfOsHdJyQxVcKyWkCsLoBwNrRiOrRcKsWxTx");

        action.setPerson(person);

        assertEquals("input", action.save());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    @Test
    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Person person = new Person();
        person.setId(-2L);
        action.setPerson(person);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}