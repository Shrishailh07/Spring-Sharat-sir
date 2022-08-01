package com.xworkz.service;

import com.xworkz.dto.CarMailDTO;

public interface CarMailService {

	boolean validateCarMail(CarMailDTO carMailDTO);
	
	boolean sendMail(CarMailDTO carMailDTO);

}
