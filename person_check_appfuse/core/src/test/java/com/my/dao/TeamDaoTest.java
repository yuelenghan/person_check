package com.my.dao;

import com.my.dao.BaseDaoTestCase;
import com.my.model.Team;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.NotTransactional;
import org.springframework.test.annotation.ExpectedException;

import java.util.List;

public class TeamDaoTest extends BaseDaoTestCase {
    @Autowired
    private TeamDao teamDao;

    @Test
    @ExpectedException(DataAccessException.class)
    public void testAddAndRemoveTeam() {
        Team team = new Team();

        // enter all required fields
        team.setName("JuUpFiUhIyGuKoQyJdEnYjXoUiBaGnHaLcTuZdTmFgSiOxFeEkArJdKlPvUgGnUmAyXfEiFfAhHbGbEyEbFzXxFjFfHdBpNkEyGrHhEdOiLbGuWbPmUqMyZlOnSsSqXiUfHtGyIcCvDeRxGjQuNdQsAfHmNfXkLuAmNhXkPaKuKcGjOzOwOuVgLlFmUtUhTzJgTpSzDj");

        log.debug("adding team...");
        team = teamDao.save(team);

        team = teamDao.get(team.getId());

        assertNotNull(team.getId());

        log.debug("removing team...");

        teamDao.remove(team.getId());

        // should throw DataAccessException 
        teamDao.get(team.getId());
    }
}