package com.xworkz.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.dto.CarMailDTO;
import com.xworkz.service.CarMailService;
import com.xworkz.service.Service;

@Controller
@RequestMapping("/")
public class CarMailController {

	@Autowired
	private CarMailService carMailService;
	
	public CarMailController() {
		System.out.println(getClass().getSimpleName() + " created");
	}
	
	@RequestMapping(value = "/getMailResource.car",method = RequestMethod.GET)
	public String getMailResource() {
		System.out.println("Invoked getMailResource");
		return "carMail";
	}
	
	@RequestMapping(value = "/readMailMessages.car",method = RequestMethod.POST)
	public String readMailMessages(@ModelAttribute CarMailDTO carMailDTO, Model model) {
		System.out.println("Invoked readMailMessages()");
		
		boolean isMailValid = this.carMailService.validateCarMail(carMailDTO);
		System.out.println(isMailValid);
		
		if(isMailValid) {
			System.out.println("Email is Valid");
			boolean send = this.carMailService.sendMail(carMailDTO);
			
			if(send) {
				model.addAttribute("MailMessage", "Email sent Successfully");
			}
			else {
				model.addAttribute("MailMessage", "Email not sent ...plz try again");
			}
		}
		else {
			System.out.println("Email is Invalid");
		}
		return "carMail";
		
	}

}
