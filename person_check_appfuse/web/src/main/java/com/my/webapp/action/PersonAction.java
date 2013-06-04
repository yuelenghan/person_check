package com.my.webapp.action;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.my.dao.SearchException;
import com.my.model.Person;
import com.my.model.Team;
import com.my.model.Unit;
import com.my.service.PersonManager;
import com.my.service.UnitManager;
import com.opensymphony.xwork2.Preparable;

public class PersonAction extends BaseAction implements Preparable {
	private PersonManager personManager;
	private List<Person> persons;
	private Person person;
	private Long id;
	private String query;

	private UnitManager unitManager;
	private List<Unit> units;
	private Map<Unit, Collection<Team>> unitAndTeam;

	public void setPersonManager(PersonManager personManager) {
		this.personManager = personManager;
	}

	public List<Person> getPersons() {
		return persons;
	}

	/**
	 * Grab the entity from the database before populating with request
	 * parameters
	 */
	public void prepare() {
		if (getRequest().getMethod().equalsIgnoreCase("post")) {
			// prevent failures on new
			String personId = getRequest().getParameter("person.id");
			if (personId != null && !personId.equals("")) {
				person = personManager.get(new Long(personId));
			}
		}
	}

	public void setQ(String q) {
		this.query = q;
	}

	public String list() {
		try {
			persons = personManager.search(query, Person.class);
		} catch (SearchException se) {
			addActionError(se.getMessage());
			persons = personManager.getAll();
		}
		return SUCCESS;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String delete() {
		personManager.remove(person.getId());
		saveMessage(getText("person.deleted"));

		return SUCCESS;
	}

	public String edit() {
		if (id != null) {
			person = personManager.get(id);
		} else {
			person = new Person();
		}
		
		units = unitManager.getAll();

		return SUCCESS;
	}

	public String save() throws Exception {
		if (cancel != null) {
			return "cancel";
		}

		if (delete != null) {
			return delete();
		}

		boolean isNew = (person.getId() == null);

		personManager.save(person);

		String key = (isNew) ? "person.added" : "person.updated";
		saveMessage(getText(key));

		if (!isNew) {
			return INPUT;
		} else {
			return SUCCESS;
		}
	}

	public Map<Unit, Collection<Team>> getUnitAndTeam() {
		return unitAndTeam;
	}

	public void setUnitManager(UnitManager unitManager) {
		this.unitManager = unitManager;
	}

	public List<Unit> getUnits() {
		return units;
	}
}