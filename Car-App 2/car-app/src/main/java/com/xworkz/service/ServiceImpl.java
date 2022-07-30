package com.xworkz.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.dao.CarDAO;
import com.xworkz.dto.CarDTO;
import com.xworkz.entity.CarEntity;

@Component
public class ServiceImpl implements Service {

	@Autowired
	private CarDAO carDAO;

	public static Map<String, String> map = new HashMap<>();
	
	public static CarEntity carEntity;

	public ServiceImpl() {
		System.out.println("ServiceImpl created");
	}

	@Override
	public boolean validateAllDetails(CarDTO carDTO) {
		boolean flag = false;
		if (carDTO.getName() != null && !carDTO.getName().isEmpty() && !carDTO.getName().isBlank()) {
			flag = true;
			System.out.println("Name is valid : " + carDTO.getName());
		} else {
			flag = false;
			System.out.println("Name is not valid : ");
			map.put("NAME", "Name is Invalid");
			return flag;
		}

		if (carDTO.getColour() != null && !carDTO.getColour().isEmpty() && !carDTO.getColour().isBlank()) {
			flag = true;
			System.out.println("Colour is valid : " + carDTO.getColour());
		} else {
			flag = false;
			System.out.println("Colour is not valid : ");
			map.put("COLOUR", "Colour is Invalid");
			return flag;
		}

		if (carDTO.getSpeed() > 0) {
			flag = true;
			System.out.println("Speed is valid : " + carDTO.getSpeed());
		} else {
			flag = false;
			System.out.println("Speed is not value : ");
			map.put("SPEED", "Speed is Invalid");
			return flag;
		}

		if (carDTO.getSeats() >= 2) {
			flag = true;
			System.out.println("Seats are valid : " + carDTO.getSeats());
		} else {
			flag = false;
			System.out.println("Seats are not valid : ");
			map.put("SEATS", "Seats are Invalid");
			return flag;
		}

		if (carDTO.getPrice() > 100000) {
			flag = true;
			System.out.println("Price is valid : " + carDTO.getPrice());
		} else {
			flag = false;
			System.out.println("Price is not valid : ");
			map.put("PRICE", "Price is Invalid");
			return flag;
		}

		return flag;
	}

	@Override
	public boolean saveAll(CarDTO carDTO) {
//		CarEntity carEntity = new CarEntity(carDTO.getName(), carDTO.getColour(), carDTO.getSpeed(), carDTO.getSeats(), carDTO.getPrice());
		
			carEntity = new CarEntity();
			BeanUtils.copyProperties(carDTO, carEntity);
			boolean carsaved = this.carDAO.saveCar(carEntity);

		
		return false;
	}

	@Override
	public boolean validateCarName(String name) {
//		boolean flag=false;
		try {
			return name != null && !name.isEmpty() && !name.isBlank() ? true : false;
//			if(name!=null && !name.isEmpty() && !name.isBlank() ) {
//				flag=true;
//		    	 System.out.println("Invoked validateCarName()"+name); 
//		       }
//		     else {
//		    	 flag=false;
//		    	 System.out.println("Not Invoked validateCarName()");
//			    }

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public CarDTO findCarDTOByName(String name) {
		CarDTO carDTO = null;
		System.out.println("Invoked findCarByName()");

		 carEntity = this.carDAO.findCarByName(name);
		if (carEntity != null) {
			carDTO = new CarDTO();
			BeanUtils.copyProperties(carEntity, carDTO);
		}
		return carDTO;
	}

	@Override
	public List<Object> getListOfCarObject() {
		List<Object> listOfCarObject = null;

		List<CarEntity> list = this.carDAO.getListOfCarEntity();

		if (list != null) {
			listOfCarObject = new ArrayList<>();
			for (CarEntity carEntity : list) {
				listOfCarObject.add(carEntity);
				System.out.println(carEntity.toString());
			}
		}
		return listOfCarObject;
	}

	@Override
	public boolean deleteByName(String name) {
		
		System.out.println("Invoked validateDeleteByName()");
		boolean validate = this.carDAO.deleteByName(name);
		return validate;
	}

	@Override
	public boolean updateCarByName(CarDTO carDTO) {

		BeanUtils.copyProperties(carDTO, carEntity);

		boolean carUpdated = this.carDAO.updateCarEntity(carEntity);
		
		return carUpdated;
	}
}
