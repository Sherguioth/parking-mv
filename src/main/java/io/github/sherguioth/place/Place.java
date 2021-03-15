package io.github.sherguioth.place;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.github.sherguioth.manager.Manager;

@Entity
@Table(name = "Places")
public class Place implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "number_palce")
	private int numberPlace;
	
	@Column(name = "state")
	private boolean state;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_id")
	private Manager manager;
	
	public Place() { }

	public Place(int numberPlace, boolean state, Manager manager) {
		this.numberPlace = numberPlace;
		this.state = state;
		this.manager = manager;
	}

	public int getNumberPlace() {
		return numberPlace;
	}

	public void setNumberPlace(int numberPlace) {
		this.numberPlace = numberPlace;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	
}
