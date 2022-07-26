package com.xworkz.dto;

public class CarDTO {

	private String name;
	private String colour;
	private int speed;
	private int seats;
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
	
	public CarDTO() {
		super();
	}
	public CarDTO(String name, String colour, int speed, int seats, int price) {
		super();
		this.name = name;
		this.colour = colour;
		this.speed = speed;
		this.seats = seats;
		this.price = price;
	}	
	
	
}
