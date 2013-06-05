package com.my.service.impl;

import java.util.List;
import java.util.Set;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dao.UnitDao;
import com.my.model.Team;
import com.my.model.Unit;
import com.my.service.UnitManager;

@Service("unitManager")
@WebService(serviceName = "UnitService", endpointInterface = "com.my.service.UnitManager")
public class UnitManagerImpl extends GenericManagerImpl<Unit, Long> implements
		UnitManager {
	UnitDao unitDao;
	
	@Autowired
	public UnitManagerImpl(UnitDao unitDao) {
		super(unitDao);
		this.unitDao = unitDao;
	}
	
	@Override
	public List<Unit> getAllAndTeams() {
		List<Unit> list = this.getAll();
		for (Unit unit : list) {
			Set<Team> teams = unit.getTeams();
			for (Team team : teams) {
			}
		}
		return list;
	}
	
}