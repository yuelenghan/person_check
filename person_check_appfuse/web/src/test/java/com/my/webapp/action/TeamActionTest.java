package com.my.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import com.my.service.TeamManager;
import com.my.model.Team;
import com.my.webapp.action.BaseActionTestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TeamActionTest extends BaseActionTestCase {
    private TeamAction action;

    @Before
    public void onSetUp() {
        super.onSetUp();

        action = new TeamAction();
        TeamManager teamManager = (TeamManager) applicationContext.getBean("teamManager");
        action.setTeamManager(teamManager);

        // add a test team to the database
        Team team = new Team();

        // enter all required fields
        team.setName("ZhCaMhVbHhVhQkWdKaPmDgPzGqIjPoHgNpPlGkRvSnOoFoJbYtLvHqKmKtAoAoVnCqSwFwKrJjQgSbWoJaYuFrFmVaEkMbPsSjUwDxRhAbGwWdIjBjXnYqHiRrKlGsAuWsNgZrYfRdAaKrRmXaUfJnZoEzDsCrVuAdHuQfKkWdJcMfAqZpBwGlPsWdLmTcOnNmIcBxCn");

        teamManager.save(team);
    }

    @Test
    public void testGetAllTeams() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getTeams().size() >= 1);
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        TeamManager teamManager = (TeamManager) applicationContext.getBean("teamManager");
        teamManager.reindex();

        action.setQ("*");
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertEquals(4, action.getTeams().size());
    }

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setId(-1L);
        assertNull(action.getTeam());
        assertEquals("success", action.edit());
        assertNotNull(action.getTeam());
        assertFalse(action.hasActionErrors());
    }

    @Test
    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setId(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getTeam());

        Team team = action.getTeam();
        // update required fields
        team.setName("UlTiLqQpMfSrFeUmEjAnWqNzVaLcWaKxHnNbQpSjClWaPtCbHxPlXfYqQyXgTqQfPfRiVpRvIbWjAqQuAwOiSdCeTrLkLuAgPmIqMcQmInPzLtDbJuNvVmBmSzWtZuStCeSyNaCqYbVaLdJmTsQdNkOvCwMbYvJzTkNaHjAqTxCzSrNdEnWnVdAhTbAcBwRvUsZaUcWl");

        action.setTeam(team);

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
        Team team = new Team();
        team.setId(-2L);
        action.setTeam(team);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}