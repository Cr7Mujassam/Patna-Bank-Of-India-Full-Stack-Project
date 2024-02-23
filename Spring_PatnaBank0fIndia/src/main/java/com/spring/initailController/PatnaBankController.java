package com.spring.initailController;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ServiceLogic.Interface.IPatnaBankService;

import ModelPackage.OpenNewAccountModel;

@Controller
@RequestMapping(value="/PatnaBank")
public class PatnaBankController {
	
	@Autowired
	public IPatnaBankService patnaBankService;
	
	//Initial Load Page for Patna Bank
		@RequestMapping(value="/")
		public String homePage() {
			return "PatnaBankHomePage";
		}
		
		//Initial Load Page for Patna Bank
		@RequestMapping(value="/formPage")
		public String formPage() {
			return "OpenAccount";
		}
	
	//for opening the account
	@ResponseBody
	@RequestMapping(value="Spring_PatnaBank0fIndia/openNewAccount" ,method = RequestMethod.POST)
	public String openNewAccount(@RequestBody OpenNewAccountModel newCustomer) {
		String opened = patnaBankService.openAccount(newCustomer); 
		return opened;
	}
	
	
	
	
}
