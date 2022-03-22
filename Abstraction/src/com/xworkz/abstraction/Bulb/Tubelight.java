package com.xworkz.abstraction.Bulb;

public class Tubelight implements Switch
{
	@Override
	public void sOn() {
		System.out.println("Tubelight is switched On");
	}
  
	@Override
	public void sOff() {
		System.out.println("Tubelight is switched Off");
	}
}
