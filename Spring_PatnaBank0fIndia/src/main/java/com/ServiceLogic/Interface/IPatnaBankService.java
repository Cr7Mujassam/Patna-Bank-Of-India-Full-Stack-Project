package com.ServiceLogic.Interface;

import ModelPackage.OpenNewAccountModel;

//no need to give component Annotation
public interface IPatnaBankService {

	// open New Account
	String openAccount(OpenNewAccountModel openNewAccount);

	// display Account No
	String showAccountNo(String PhoneNo);

	// withdraw balance
	public String amountWithdraw(String accNo, String ammount);

	// deposit balance
	public String amountDeposit(String accNo, String ammount);
}
