package com.my.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.my.dao.UnitDao;
import com.my.model.Unit;
import com.my.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class UnitManagerImplTest extends BaseManagerMockTestCase {
    private UnitManagerImpl manager = null;
    private UnitDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(UnitDao.class);
        manager = new UnitManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetUnit() {
        log.debug("testing get...");

        final Long id = 7L;
        final Unit unit = new Unit();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(id)));
            will(returnValue(unit));
        }});

        Unit result = manager.get(id);
        assertSame(unit, result);
    }

    @Test
    public void testGetUnits() {
        log.debug("testing getAll...");

        final List units = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(units));
        }});

        List result = manager.getAll();
        assertSame(units, result);
    }

    @Test
    public void testSaveUnit() {
        log.debug("testing save...");

        final Unit unit = new Unit();
        // enter all required fields
        unit.setName("RaXqJzLoXgKkNwJhFtSgFvIcWgLkGzAdBxJjEkQfZtQjMnXgIlKvRdOuRbSiShRfNhXrLsVhUxIxYpDtIeGyGtLoOsRtCxCrWmBwEyIrEwYaUhNhObRvWpPfIfBsOqZfKpZbWuQqEnIzKhHwFzLxOtCdSwMdZwIiRqVnUxBoGsRwXhGvSiUqVgArKcLvVvRvYbKpThWt");
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(unit)));
        }});

        manager.save(unit);
    }

    @Test
    public void testRemoveUnit() {
        log.debug("testing remove...");

        final Long id = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(id)));
        }});

        manager.remove(id);
    }
}