package com.xworkz.dao;

import java.util.List;

import com.xworkz.entity.CarEntity;

public interface CarDAO {

	boolean saveCar( CarEntity carEntity); 
   public CarEntity findCarByName(String name);
   List<CarEntity> getListOfCarEntity();
    boolean deleteByName(String name);
	boolean updateCarEntity(CarEntity carEntity);
}
