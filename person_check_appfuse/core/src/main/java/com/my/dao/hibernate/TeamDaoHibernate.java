package com.my.dao.hibernate;

import com.my.model.Team;
import com.my.dao.TeamDao;
import com.my.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("teamDao")
public class TeamDaoHibernate extends GenericDaoHibernate<Team, Long> implements TeamDao {

    public TeamDaoHibernate() {
        super(Team.class);
    }
}
