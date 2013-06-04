package com.my.model;

import com.my.model.BaseObject;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name = "team", catalog = "person_check_appfuse")
@Indexed
@XmlRootElement
public class Team extends BaseObject implements Serializable {
	private Long id;
	private Unit unit;
	private String name;
	private Set<Person> persons = new HashSet<Person>(0);

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@DocumentId
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "unit", nullable = false)
	public Unit getUnit() {
		return this.unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	@Column(name = "name", nullable = false, length = 200)
	@Field
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "team")
	public Set<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Team pojo = (Team) o;

		if (unit != null ? !unit.equals(pojo.unit) : pojo.unit != null)
			return false;
		if (name != null ? !name.equals(pojo.name) : pojo.name != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result = 0;
		result = (unit != null ? unit.hashCode() : 0);
		result = 31 * result + (name != null ? name.hashCode() : 0);

		return result;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer(getClass().getSimpleName());

		sb.append(" [");
		sb.append("id").append("='").append(getId()).append("', ");
		sb.append("unit").append("='").append(getUnit()).append("', ");
		sb.append("name").append("='").append(getName()).append("', ");

		sb.append("]");

		return sb.toString();
	}

}
