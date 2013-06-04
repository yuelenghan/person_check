package com.my.model;

import com.my.model.BaseObject;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name = "person", catalog = "person_check_appfuse")
@Indexed
@XmlRootElement
public class Person extends BaseObject implements Serializable {
	private Long id;
	private Unit unit;
	private Team team;
	private Long age;
	private String gpsCard;
	private String idCard;
	private boolean ifBeon;
	private boolean ifPic;
	private String job;
	private String lightCard;
	private String name;
	private Long normalTime;
	private String politicLevel;
	private String sex;
	private boolean specType;
	private String workCard;
	private String workType;

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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "team", nullable = false)
	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Column(name = "age")
	@Field
	public Long getAge() {
		return this.age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	@Column(name = "gps_card", length = 200)
	@Field
	public String getGpsCard() {
		return this.gpsCard;
	}

	public void setGpsCard(String gpsCard) {
		this.gpsCard = gpsCard;
	}

	@Column(name = "idCard", nullable = false, length = 20)
	@Field
	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@Column(name = "if_beon", nullable = false)
	@Field
	public boolean isIfBeon() {
		return this.ifBeon;
	}

	public void setIfBeon(boolean ifBeon) {
		this.ifBeon = ifBeon;
	}

	@Column(name = "if_pic", nullable = false)
	@Field
	public boolean isIfPic() {
		return this.ifPic;
	}

	public void setIfPic(boolean ifPic) {
		this.ifPic = ifPic;
	}

	@Column(name = "job", length = 200)
	@Field
	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Column(name = "light_card", length = 200)
	@Field
	public String getLightCard() {
		return this.lightCard;
	}

	public void setLightCard(String lightCard) {
		this.lightCard = lightCard;
	}

	@Column(name = "name", nullable = false, length = 200)
	@Field
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "normal_time", nullable = false)
	@Field
	public Long getNormalTime() {
		return this.normalTime;
	}

	public void setNormalTime(Long normalTime) {
		this.normalTime = normalTime;
	}

	@Column(name = "politic_level", length = 200)
	@Field
	public String getPoliticLevel() {
		return this.politicLevel;
	}

	public void setPoliticLevel(String politicLevel) {
		this.politicLevel = politicLevel;
	}

	@Column(name = "sex", nullable = false, length = 2)
	@Field
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "spec_type", nullable = false)
	@Field
	public boolean isSpecType() {
		return this.specType;
	}

	public void setSpecType(boolean specType) {
		this.specType = specType;
	}

	@Column(name = "work_card", nullable = false, length = 200)
	@Field
	public String getWorkCard() {
		return this.workCard;
	}

	public void setWorkCard(String workCard) {
		this.workCard = workCard;
	}

	@Column(name = "work_type", length = 200)
	@Field
	public String getWorkType() {
		return this.workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Person pojo = (Person) o;

		if (unit != null ? !unit.equals(pojo.unit) : pojo.unit != null)
			return false;
		if (team != null ? !team.equals(pojo.team) : pojo.team != null)
			return false;
		if (age != null ? !age.equals(pojo.age) : pojo.age != null)
			return false;
		if (gpsCard != null ? !gpsCard.equals(pojo.gpsCard)
				: pojo.gpsCard != null)
			return false;
		if (idCard != null ? !idCard.equals(pojo.idCard) : pojo.idCard != null)
			return false;
		if (ifBeon != pojo.ifBeon)
			return false;
		if (ifPic != pojo.ifPic)
			return false;
		if (job != null ? !job.equals(pojo.job) : pojo.job != null)
			return false;
		if (lightCard != null ? !lightCard.equals(pojo.lightCard)
				: pojo.lightCard != null)
			return false;
		if (name != null ? !name.equals(pojo.name) : pojo.name != null)
			return false;
		if (normalTime != null ? !normalTime.equals(pojo.normalTime)
				: pojo.normalTime != null)
			return false;
		if (politicLevel != null ? !politicLevel.equals(pojo.politicLevel)
				: pojo.politicLevel != null)
			return false;
		if (sex != null ? !sex.equals(pojo.sex) : pojo.sex != null)
			return false;
		if (specType != pojo.specType)
			return false;
		if (workCard != null ? !workCard.equals(pojo.workCard)
				: pojo.workCard != null)
			return false;
		if (workType != null ? !workType.equals(pojo.workType)
				: pojo.workType != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result = 0;
		result = (unit != null ? unit.hashCode() : 0);
		result = 31 * result + (team != null ? team.hashCode() : 0);
		result = 31 * result + (age != null ? age.hashCode() : 0);
		result = 31 * result + (gpsCard != null ? gpsCard.hashCode() : 0);
		result = 31 * result + (idCard != null ? idCard.hashCode() : 0);
		result = 31 * result + (ifBeon ? 1 : 0);
		result = 31 * result + (ifPic ? 1 : 0);
		result = 31 * result + (job != null ? job.hashCode() : 0);
		result = 31 * result + (lightCard != null ? lightCard.hashCode() : 0);
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (normalTime != null ? normalTime.hashCode() : 0);
		result = 31 * result
				+ (politicLevel != null ? politicLevel.hashCode() : 0);
		result = 31 * result + (sex != null ? sex.hashCode() : 0);
		result = 31 * result + (specType ? 1 : 0);
		result = 31 * result + (workCard != null ? workCard.hashCode() : 0);
		result = 31 * result + (workType != null ? workType.hashCode() : 0);

		return result;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer(getClass().getSimpleName());

		sb.append(" [");
		sb.append("id").append("='").append(getId()).append("', ");
		sb.append("unit").append("='").append(getUnit()).append("', ");
		sb.append("team").append("='").append(getTeam()).append("', ");
		sb.append("age").append("='").append(getAge()).append("', ");
		sb.append("gpsCard").append("='").append(getGpsCard()).append("', ");
		sb.append("idCard").append("='").append(getIdCard()).append("', ");
		sb.append("ifBeon").append("='").append(isIfBeon()).append("', ");
		sb.append("ifPic").append("='").append(isIfPic()).append("', ");
		sb.append("job").append("='").append(getJob()).append("', ");
		sb.append("lightCard").append("='").append(getLightCard())
				.append("', ");
		sb.append("name").append("='").append(getName()).append("', ");
		sb.append("normalTime").append("='").append(getNormalTime())
				.append("', ");
		sb.append("politicLevel").append("='").append(getPoliticLevel())
				.append("', ");
		sb.append("sex").append("='").append(getSex()).append("', ");
		sb.append("specType").append("='").append(isSpecType()).append("', ");
		sb.append("workCard").append("='").append(getWorkCard()).append("', ");
		sb.append("workType").append("='").append(getWorkType()).append("'");
		sb.append("]");

		return sb.toString();
	}

}
