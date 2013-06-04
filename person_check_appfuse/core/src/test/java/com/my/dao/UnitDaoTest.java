package com.my.dao;

import com.my.dao.BaseDaoTestCase;
import com.my.model.Unit;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.NotTransactional;
import org.springframework.test.annotation.ExpectedException;

import java.util.List;

public class UnitDaoTest extends BaseDaoTestCase {
    @Autowired
    private UnitDao unitDao;

    @Test
    @ExpectedException(DataAccessException.class)
    public void testAddAndRemoveUnit() {
        Unit unit = new Unit();

        // enter all required fields
        unit.setName("CkVnZlCbExOvAyMeWhJhKbHzLaVnJpVqQsPbXjEyQlOzAsRbEjNzVtTdPkBvNeHqDqWsFyViOyGzZrKeBtRsTxWmTmUxUtRvBdWsWoWwMzXzRtOmMsArNfYvVlLwWmCbYiZgDxQsDrGfPiMmRgCmKwTtPjZjKsXhItWxVpMeVnJkBcGkSuKfLpNaRhMyKlRdKsOaMuQd");

        log.debug("adding unit...");
        unit = unitDao.save(unit);

        unit = unitDao.get(unit.getId());

        assertNotNull(unit.getId());

        log.debug("removing unit...");

        unitDao.remove(unit.getId());

        // should throw DataAccessException 
        unitDao.get(unit.getId());
    }
}