package com.my.dao.hibernate;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.my.dao.UnitDao;
import com.my.model.Team;
import com.my.model.Unit;

@Repository("unitDao")
public class UnitDaoHibernate extends GenericDaoHibernate<Unit, Long> implements
		UnitDao {
	
	public UnitDaoHibernate() {
		super(Unit.class);
	}
	
}
