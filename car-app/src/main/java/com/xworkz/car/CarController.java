package com.xworkz.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.service.ServiceImpl;

@Component
@RequestMapping("/")
public class CarController {
	
@Autowired	
private ServiceImpl serviceImpl;

public CarController() {
System.out.println(getClass().getSimpleName()+" created");
}

@RequestMapping("/getValues")
public String getValues() {
	System.out.println("Invoked getValues()");
	return "/WEB-INF/car.jsp";
}

@RequestMapping("/readValues")
public String readValues(@RequestParam String name,@RequestParam String colour,@RequestParam int speed,
		@RequestParam int seats,@RequestParam int price,Model model) {
    System.out.println("Invoked readValues()");
	System.out.println("Car name : "+name);
	System.out.println("Car colour : "+colour);
	System.out.println("Car speed : "+speed);
	System.out.println("Car seats : "+seats);
	System.out.println("Car price : "+price);
	
	boolean valid = this.serviceImpl.validateAllDetails(name, colour, speed, seats, price,model);
	System.out.println(valid);
	
	if(valid) {
		System.out.println("Data is Valid");
		boolean result=this.serviceImpl.saveAll(name, colour, speed, seats, price);
		System.out.println(result);
		
		if(result=true) {
			System.out.println("Saved to Database");
		}
		else {
			System.out.println("Not Saved to Database");
			model.addAttribute("errorName", "Enter Name");
		}
	}
	else {
		System.out.println("Data is Not Valid");
		
	}
	
	return "/WEB-INF/car.jsp";
}




}