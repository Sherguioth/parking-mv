package io.github.sherguioth.park;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.github.sherguioth.place.Place;
import io.github.sherguioth.vehicle.Vehicle;

@Entity
@Table(name = "Parks")
public class Park implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "park_id")
	private long id;
	
	@Column(name = "entry_date")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Calendar entryDate;
	
	@Column(name = "exit_date")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Calendar exitDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "number_place")
	private Place place;
	
	public Park() { }

	public Park(long id, Calendar entryDate, Calendar exitDate, Vehicle vehicle, Place place) {
		this.id = id;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
		this.vehicle = vehicle;
		this.place = place;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "Park [id=" + id + ", entryDate=" + entryDate + ", exitDate=" + exitDate + ", vehicle=" + vehicle.getLicensePlate()
				+ ", place=" + place.getNumberPlace() + "]";
	}
}
