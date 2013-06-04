package com.my.service;

import java.util.Collection;
import java.util.Map;

import javax.jws.WebService;

import com.my.model.Team;
import com.my.model.Unit;

@WebService
public interface UnitManager extends GenericManager<Unit, Long> {
    
	public Map<Unit, Collection<Team>> getUnitAndTeam();
}