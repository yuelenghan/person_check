package com.my.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map<Unit, Collection<Team>> getUnitAndTeam() {
		Map<Unit, Collection<Team>> unitAndTeam = new HashMap<Unit, Collection<Team>>();
		
		List<Unit> units = unitDao.getAll();
		for (Unit unit : units) {
			unitAndTeam.put(unit, unit.getTeams());
		}
		return unitAndTeam;
	}
}