package com.my.service;

import java.util.List;

import javax.jws.WebService;

import com.my.model.Team;

@WebService
public interface TeamManager extends GenericManager<Team, Long> {
    
	public List<Team> getAllAndUnits();
}