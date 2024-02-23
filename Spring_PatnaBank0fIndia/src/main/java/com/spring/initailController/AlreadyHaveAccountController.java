package com.spring.initailController;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ServiceLogic.Interface.IPatnaBankService;

import ModelPackage.PhoneNoForDisplayAccountNo;
import ModelPackage.WithDrawAmount;

@Controller
public class AlreadyHaveAccountController {

	@Autowired
	IPatnaBankService iPatnaBankService;

	// for showing Existing Banking Customer Options
	@RequestMapping(value = "/PatnaBank/Options")
	public String alreadyAccOption() {
		return "ExistingCustomerDashboard";
	}

	// for Displaying the Account Number
	@ResponseBody
	@RequestMapping(value = "/PatnaBank/display/AccountNo")
	public String displayAccountNum(@RequestBody PhoneNoForDisplayAccountNo phoneNo) {
		return iPatnaBankService.showAccountNo(phoneNo.getPhoneNo());
	}

	// for withdrawing account balance
	@ResponseBody
	@RequestMapping(value = "/PatnaBank/withdraw/ammount")
	public String withdrawAmount(@RequestBody WithDrawAmount Balance) {
		return iPatnaBankService.amountWithdraw(Balance.getAccountNumber(), Balance.getWithdrawAmount());
	}

	// for depositing balance
	@ResponseBody
	@RequestMapping(value = "/PatnaBank/deposit/ammount")
	public String depositAmount(@RequestBody WithDrawAmount Balance) {
		return iPatnaBankService.amountDeposit(Balance.getAccountNumber(), Balance.getDepositAmount());
	}

}
