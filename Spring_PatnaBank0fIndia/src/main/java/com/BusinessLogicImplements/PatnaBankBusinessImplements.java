package com.BusinessLogicImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.BusinessLogicInterface.IPatnaBankBusiness;
import com.PatnaBankDAOInterface.IPatnaBankDAO;

import ModelPackage.OpenNewAccountModel;

@Component
public class PatnaBankBusinessImplements implements IPatnaBankBusiness{
	
	@Autowired
	IPatnaBankDAO PatnaBankDAO;
	
	//for Opening Account
	public String openAccount(OpenNewAccountModel openNewAccount) {
		return  PatnaBankDAO.openAccount(openNewAccount);
	}

	public String showAccountNo(String phoneNo) {
		return PatnaBankDAO.showAccountNo(phoneNo);
	}
	
	//for withdrawing balance
	public String amountWithdraw(String accNo, String balance) {
		String preBalance = PatnaBankDAO.amountWithdraw(accNo,balance);
		int pre = Integer.parseInt(preBalance);
		int wthDrw = Integer.parseInt(balance);
		
		if(wthDrw<pre) {
			int calculation = pre - wthDrw;
			String updateAfterWithdraw = PatnaBankDAO.updateAmount(accNo,String.valueOf(calculation));
			
			if(updateAfterWithdraw.equalsIgnoreCase("yes")) {
				return String.valueOf(calculation);
			}else {
				return "Error";
			}
		}else {
			return "Please Enter Less Amount because Your Remaining Balnace:-" + pre;
		}
	}
	
	//for depositing Balance
	public String amountDeposit(String accNo, String balance) {
		String preBalance = PatnaBankDAO.amountWithdraw(accNo,balance);
		int pre = Integer.parseInt(preBalance);
		int deposit = Integer.parseInt(balance);
		int calculation = pre + deposit;
		String updateAfterWithdraw = PatnaBankDAO.updateAmount(accNo,String.valueOf(calculation));
		
		if(updateAfterWithdraw.equalsIgnoreCase("yes")) {
			return String.valueOf(calculation);
		}else {
			return "Error";
		}
	}

}
