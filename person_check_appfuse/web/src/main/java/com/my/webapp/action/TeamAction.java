package com.my.webapp.action;

import java.util.List;

import com.my.dao.SearchException;
import com.my.model.Team;
import com.my.model.Unit;
import com.my.service.TeamManager;
import com.my.service.UnitManager;
import com.opensymphony.xwork2.Preparable;

public class TeamAction extends BaseAction implements Preparable {
	private TeamManager teamManager;
	private List<Team> teams;
	private Team team;
	private Long id;
	private String query;

	private List<Unit> units;
	private UnitManager unitManager;

	public void setTeamManager(TeamManager teamManager) {
		this.teamManager = teamManager;
	}

	public List<Team> getTeams() {
		return teams;
	}

	/**
	 * Grab the entity from the database before populating with request
	 * parameters
	 */
	public void prepare() {
		if (getRequest().getMethod().equalsIgnoreCase("post")) {
			// prevent failures on new
			String teamId = getRequest().getParameter("team.id");
			if (teamId != null && !teamId.equals("")) {
				team = teamManager.get(new Long(teamId));
			}
		}
	}

	public void setQ(String q) {
		this.query = q;
	}

	public String list() {
		try {
			teams = teamManager.search(query, Team.class);
		} catch (SearchException se) {
			addActionError(se.getMessage());
			teams = teamManager.getAll();
		}
		return SUCCESS;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String delete() {
		teamManager.remove(team.getId());
		saveMessage(getText("team.deleted"));

		return SUCCESS;
	}

	public String edit() {
		if (id != null) {
			team = teamManager.get(id);
		} else {
			team = new Team();
		}
		
		units = unitManager.getAll();

		return SUCCESS;
	}

	public String save() throws Exception {
		if (cancel != null) {
			return "cancel";
		}

		if (delete != null) {
			return delete();
		}

		boolean isNew = (team.getId() == null);

		teamManager.save(team);

		String key = (isNew) ? "team.added" : "team.updated";
		saveMessage(getText(key));

		if (!isNew) {
			return INPUT;
		} else {
			return SUCCESS;
		}
	}

	public List<Unit> getUnits() {
		return units;
	}

	public void setUnitManager(UnitManager unitManager) {
		this.unitManager = unitManager;
	}
}