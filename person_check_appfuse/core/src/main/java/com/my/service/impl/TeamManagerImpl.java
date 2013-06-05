package com.my.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dao.TeamDao;
import com.my.model.Team;
import com.my.service.TeamManager;

@Service("teamManager")
@WebService(serviceName = "TeamService", endpointInterface = "com.my.service.TeamManager")
public class TeamManagerImpl extends GenericManagerImpl<Team, Long> implements
		TeamManager {
	TeamDao teamDao;
	
	@Autowired
	public TeamManagerImpl(TeamDao teamDao) {
		super(teamDao);
		this.teamDao = teamDao;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<Team> search(String q, Class clazz) {
		if (q == null || "".equals(q.trim())) {
			return getAllAndUnits();
		}
		
		return dao.search(q);
	}
	
	@Override
	public List<Team> getAllAndUnits() {
		List<Team> list = this.getAll();
		for (Team team : list) {
			team.getUnit().getName();
		}
		return list;
	}
}