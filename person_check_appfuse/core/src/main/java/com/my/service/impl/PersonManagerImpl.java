package com.my.service.impl;

import com.my.dao.PersonDao;
import com.my.model.Person;
import com.my.model.Team;
import com.my.service.PersonManager;
import com.my.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("personManager")
@WebService(serviceName = "PersonService", endpointInterface = "com.my.service.PersonManager")
public class PersonManagerImpl extends GenericManagerImpl<Person, Long>
		implements PersonManager {
	PersonDao personDao;
	
	@Autowired
	public PersonManagerImpl(PersonDao personDao) {
		super(personDao);
		this.personDao = personDao;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<Person> search(String q, Class clazz) {
		if (q == null || "".equals(q.trim())) {
			return getAllAndUnitsTeams();
		}
		
		return dao.search(q);
	}
	
	@Override
	public List<Person> getAllAndUnitsTeams() {
		List<Person> list = this.getAll();
		for (Person person : list) {
			person.getTeam().getName();
			person.getUnit().getName();
		}
		return list;
	}
}