package com.PatnaBankDAOInterface;

import org.springframework.stereotype.Component;

import ModelPackage.OpenNewAccountModel;

public interface IPatnaBankDAO {
	
	//for Opening Account
	public String openAccount(OpenNewAccountModel openNewAccount);
	
	//for showing Account Details
	public String showAccountNo(String phoneNo);
	
	//for withdrawing Balance
	public String amountWithdraw(String accNo, String balance);
	
	//updating after withdraw
	public String updateAmount(String accNo,String balance);
}
