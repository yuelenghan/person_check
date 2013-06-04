package com.my.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.my.dao.TeamDao;
import com.my.model.Team;
import com.my.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class TeamManagerImplTest extends BaseManagerMockTestCase {
    private TeamManagerImpl manager = null;
    private TeamDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(TeamDao.class);
        manager = new TeamManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetTeam() {
        log.debug("testing get...");

        final Long id = 7L;
        final Team team = new Team();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(id)));
            will(returnValue(team));
        }});

        Team result = manager.get(id);
        assertSame(team, result);
    }

    @Test
    public void testGetTeams() {
        log.debug("testing getAll...");

        final List teams = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(teams));
        }});

        List result = manager.getAll();
        assertSame(teams, result);
    }

    @Test
    public void testSaveTeam() {
        log.debug("testing save...");

        final Team team = new Team();
        // enter all required fields
        team.setName("DkEyAnYpNxTfWtRsGxPiNgYdSqAtZlLeBvLkFqLmYxWkRjIoRpUaNvHtZxLuEkTaCkKaKpEhCaMqDkGvDmYlJpAdKrSyMcRwAcDwZcZfUfJcJmRaRvIjVwJkAfEgNiIbYvMfSwXtPcIkFkXiHdStDoAmExEbTsEaPtWvObJdBiVkWrAlFaUaKkPmRfLiLbQrGzXyZgGn");
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(team)));
        }});

        manager.save(team);
    }

    @Test
    public void testRemoveTeam() {
        log.debug("testing remove...");

        final Long id = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(id)));
        }});

        manager.remove(id);
    }
}