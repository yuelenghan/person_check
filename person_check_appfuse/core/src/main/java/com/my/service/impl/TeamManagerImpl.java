package com.my.service.impl;

import com.my.dao.TeamDao;
import com.my.model.Team;
import com.my.service.TeamManager;
import com.my.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("teamManager")
@WebService(serviceName = "TeamService", endpointInterface = "com.my.service.TeamManager")
public class TeamManagerImpl extends GenericManagerImpl<Team, Long> implements TeamManager {
    TeamDao teamDao;

    @Autowired
    public TeamManagerImpl(TeamDao teamDao) {
        super(teamDao);
        this.teamDao = teamDao;
    }
}