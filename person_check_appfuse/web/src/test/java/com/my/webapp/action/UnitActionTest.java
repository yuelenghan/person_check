package com.my.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import com.my.service.UnitManager;
import com.my.model.Unit;
import com.my.webapp.action.BaseActionTestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UnitActionTest extends BaseActionTestCase {
    private UnitAction action;

    @Before
    public void onSetUp() {
        super.onSetUp();

        action = new UnitAction();
        UnitManager unitManager = (UnitManager) applicationContext.getBean("unitManager");
        action.setUnitManager(unitManager);

        // add a test unit to the database
        Unit unit = new Unit();

        // enter all required fields
        unit.setName("WoIuWnCiSlRwIaUzTbNlBlQjKpXoGzKcCzLzPrOuMzJyHePaEoQyVpOzMkVeLiRaRqRdBqYvRiKlVkWoZoUlGeHuJmMcFbBfPzHpXyYkSqTlEuMgQhDuEoTqWdNiOpInNtHtHsVqQkDkUyBmUcFdKiJdFhSgHwPyCeEpGbMqXlCeXuKyLxOcUgKaNpTqJuFaFfFfGcMv");

        unitManager.save(unit);
    }

    @Test
    public void testGetAllUnits() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getUnits().size() >= 1);
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        UnitManager unitManager = (UnitManager) applicationContext.getBean("unitManager");
        unitManager.reindex();

        action.setQ("*");
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertEquals(4, action.getUnits().size());
    }

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setId(-1L);
        assertNull(action.getUnit());
        assertEquals("success", action.edit());
        assertNotNull(action.getUnit());
        assertFalse(action.hasActionErrors());
    }

    @Test
    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setId(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getUnit());

        Unit unit = action.getUnit();
        // update required fields
        unit.setName("VwKqQpYvTkMdIaGcVoFrLxYfWiRxWnVaYpVlVlRqNfWuOgFyAgAkOkNuSeKfAjOdOcAyQpEuKiPyGdZfHwUiAdFrStXjEaVzBePkZmYfEwWnMvMdOdTdWhWzAtCcYlCjUdRpOrAdBzBvQmMgOdWaGyDfCfZhWrVmTiMlYeSmWgQhXgXeSiWyFzUkDfDnMrYiFqHaWdTy");

        action.setUnit(unit);

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
        Unit unit = new Unit();
        unit.setId(-2L);
        action.setUnit(unit);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}