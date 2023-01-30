package com.demo.meeting_room_booking;

import java.sql.Date;

public class Room {
	
	private Integer id;
	
	private String name;
	
	private Integer capacity;
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	

	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", capacity=" + capacity + ",  getId()="
				+ getId() + ", getName()=" + getName() + ", getCapacity()=" + getCapacity() + ", toString()="
				+ super.toString() + "]";
	}
}