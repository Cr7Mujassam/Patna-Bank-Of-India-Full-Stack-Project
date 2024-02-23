package com.ServiceLogic.Implements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.BusinessLogicInterface.IPatnaBankBusiness;
import com.ServiceLogic.Interface.IPatnaBankService;

import ModelPackage.OpenNewAccountModel;

@Component
public class PatnaBankServiceImplements implements IPatnaBankService {
	
	
	 @Autowired 
	 IPatnaBankBusiness PatnaBankBusiness;
	 
	
	//for opening new Account
	public String openAccount(OpenNewAccountModel customerData ) {
		return PatnaBankBusiness.openAccount(customerData);
	}

	//show Account Number
	public String showAccountNo(String phoneNo) {
		return PatnaBankBusiness.showAccountNo(phoneNo);
	}

	//withdraw Amount
	public String amountWithdraw(String accNo, String ammount) {
		return PatnaBankBusiness.amountWithdraw(accNo,ammount);
	}

	public String amountDeposit(String accNo, String ammount) {
		return PatnaBankBusiness.amountDeposit(accNo,ammount);
	}

}
