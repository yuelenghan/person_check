package com.my.service;

import java.util.List;

import javax.jws.WebService;

import com.my.model.Unit;

@WebService
public interface UnitManager extends GenericManager<Unit, Long> {
	
    public List<Unit> getAllAndTeams();
}