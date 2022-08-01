package com.xworkz.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.xworkz.dto.CarMailDTO;

@Service
public class CarMailServiceImpl implements CarMailService{
	
	@Autowired
	private JavaMailSender mailSender;

	
	
	public CarMailServiceImpl() {
		super();
System.out.println("CarMailServiceImpl created");
	}

	@Override
	public boolean validateCarMail(CarMailDTO carMailDTO) {
		boolean valid=false;
		System.out.println("Invoked validateCarMail");
		
		if (carMailDTO.getToEmail() != null && !carMailDTO.getToEmail().isEmpty() && !carMailDTO.getToEmail().isBlank()) {
			valid = true;
			System.out.println("Email is valid : " + carMailDTO.getToEmail());
		} else {
			valid = false;
			System.out.println("Email is not valid : ");
			return valid;
		}
		
		if (carMailDTO.getSubject() != null && !carMailDTO.getSubject().isEmpty() && !carMailDTO.getSubject().isBlank()) {
			valid = true;
			System.out.println("Subject is valid : " + carMailDTO.getSubject());
		} else {
			valid = false;
			System.out.println("Subject is not valid : ");
			return valid;
		}
		
		if (carMailDTO.getBodyText() != null && !carMailDTO.getBodyText().isEmpty() && !carMailDTO.getBodyText().isBlank()) {
			valid = true;
			System.out.println("BodyText is valid : " + carMailDTO.getBodyText());
		} else {
			valid = false;
			System.out.println("BodyText is not valid : ");
			return valid;
		}
		return valid;
	}

	@Override
	public boolean sendMail(CarMailDTO carMailDTO) {
    boolean sent = false;
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(carMailDTO.getToEmail());
		simpleMailMessage.setFrom("shrishail7@outlook.com");
        simpleMailMessage.setSubject(carMailDTO.getSubject());
        simpleMailMessage.setText(carMailDTO.getBodyText());
        
        this.mailSender.send(simpleMailMessage);
        
		return sent;
	}

}
