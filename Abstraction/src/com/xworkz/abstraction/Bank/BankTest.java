package com.xworkz.abstraction.Bank;

public class BankTest 
{
	public static void main(String[] args) 
{
	
 ATM abc = new HDFCbankimpl();
 abc.swipe();

 ATM xyz = new SBIbankimpl();
 xyz.swipe();

 ATM pqr = new IDBIbankimpl();
 pqr.swipe();

}
}
