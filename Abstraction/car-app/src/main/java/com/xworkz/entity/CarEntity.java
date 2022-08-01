package com.xworkz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Car")
@NamedQuery(name="CarEntity.findCarByName",query ="from CarEntity where name=:NAME")
@NamedQuery(name ="CarEntity.getListOfCarEntity", query = "from CarEntity")
@NamedQuery(name="CarEntity.deleteByName", query = "delete from CarEntity where name=:DELETE_NAME")
@NamedQuery(name ="CarEntity.updateCarEntity", query = "update CarEntity set name=:NAME, colour=:COLOUR, speed=:SPEED, seats=:SEATS, price=:PRICE where name=:SetByName")
public class CarEntity {

@Id	
@Column(name = "Car_id")
@GenericGenerator(name = "m", strategy = "increment")
@GeneratedValue(generator = "m")
private int id;

@Column(name = "Car_name")
private String name;

@Column(name = "Car_colour")
private String colour;

@Column(name = "Car_speed")
private int speed;

@Column(name = "Car_seats")
private int seats;

@Column(name = "Car_price")
private int price;


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getColour() {
	return colour;
}
public void setColour(String colour) {
	this.colour = colour;
}
public int getSpeed() {
	return speed;
}
public void setSpeed(int speed) {
	this.speed = speed;
}
public int getSeats() {
	return seats;
}
public void setSeats(int seats) {
	this.seats = seats;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}


public CarEntity() {

}

public CarEntity(String name, String colour, int speed, int seats, int price) {
	super();
	this.name = name;
	this.colour = colour;
	this.speed = speed;
	this.seats = seats;
	this.price = price;
}
@Override
public String toString() {
	return "CarEntity [name=" + name + ", colour=" + colour + ", speed=" + speed + ", seats=" + seats + ", price="
			+ price + "]";
}


}
