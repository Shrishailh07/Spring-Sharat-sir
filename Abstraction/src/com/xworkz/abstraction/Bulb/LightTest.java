package com.xworkz.abstraction.Bulb;

public class LightTest
{
public static void main(String[] args) 
 {
	//Abstraction
	Switch switch1 = LightFactory.getLight("cflBulb");
	if(switch1!=null)
	{
		switch1.sOn();
		switch1.sOff();
	}
	//Abstraction
	Switch switch2 = new Tubelight();
	switch2.sOn();
	switch2.sOff();
}
}
