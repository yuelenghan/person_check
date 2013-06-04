package com.my.service;

import com.my.service.GenericManager;
import com.my.model.Team;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface TeamManager extends GenericManager<Team, Long> {
    
}