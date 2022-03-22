package com.xworkz.abstraction.Bulb;

public class LightFactory                                                 
{
public static  Switch getLight(String type)
{
	if(type.equalsIgnoreCase("Tubelight"))
	{
		return new Tubelight();
	}
	else if(type.equalsIgnoreCase("CflBulb"))
	{
		return new CflBulb();
	}
	return null;
		
	}
  }

