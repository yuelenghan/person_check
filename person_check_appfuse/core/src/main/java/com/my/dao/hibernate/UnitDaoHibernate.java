package com.my.dao.hibernate;

import com.my.model.Unit;
import com.my.dao.UnitDao;
import com.my.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("unitDao")
public class UnitDaoHibernate extends GenericDaoHibernate<Unit, Long> implements UnitDao {

    public UnitDaoHibernate() {
        super(Unit.class);
    }
}
