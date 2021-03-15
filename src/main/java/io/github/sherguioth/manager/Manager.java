package io.github.sherguioth.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.github.sherguioth.place.Place;

@Entity
@Table(name = "Managers")
public class Manager implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manager_id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "entry_date")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Calendar entryDate;
	
	@Column(name = "exit_date")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Calendar exitDate;
	
	@OneToMany(mappedBy = "manager", fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Place> places = new ArrayList<Place>();
	
	public Manager() { }

	public Manager(long id, String name, Calendar entryDate, Calendar exitDate) {
		this.id = id;
		this.name = name;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Calendar entryDate) {
		this.entryDate = entryDate;
	}

	public Calendar getExitDate() {
		return exitDate;
	}

	public void setExitDate(Calendar exitDate) {
		this.exitDate = exitDate;
	}

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", entryDate=" + entryDate + ", exitDate=" + exitDate + "]";
	}
}
