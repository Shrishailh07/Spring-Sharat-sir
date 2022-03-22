package com.xworkz.abstraction.Bank;

public class BankFactory 
{
public static ATM getBank(String name) 
  {
	if(name.equalsIgnoreCase("HDFCbank"))
	{
	return new HDFCbankimpl();
	}
	else if(name.equalsIgnoreCase("SBIbank"))
	{
		return new SBIbankimpl();
	}
	else if(name.equalsIgnoreCase("IDBIbank"))
	{
		return new IDBIbankimpl();
	}
	return null;
   }
}
