package com.BusinessLogicInterface;

import ModelPackage.OpenNewAccountModel;

public interface IPatnaBankBusiness {

	// opening Account Business Logic
	public String openAccount(OpenNewAccountModel openNewAccount);

	// show Account No
	public String showAccountNo(String phoneNo);

	// withdraw amount
	public String amountWithdraw(String accNo, String balance);

	// Deposit amount
	public String amountDeposit(String accNo, String balance);
}
