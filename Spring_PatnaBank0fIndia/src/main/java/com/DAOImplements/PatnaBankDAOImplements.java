package com.DAOImplements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.PatnaBankDAOInterface.IPatnaBankDAO;

import ModelPackage.ListOfSerialNo;
import ModelPackage.OpenNewAccountModel;

@Component
public class PatnaBankDAOImplements implements IPatnaBankDAO {
	
	//calling template
	private JdbcTemplate template;
	
	//setting the template
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	
	public JdbcTemplate getJdbcTemplate() {
        return template;
    }
	
	//DataBase Logic for Opening Account
	public String openAccount(OpenNewAccountModel openNewAccount) {
			int rowInserted = 0;
				try {
					String query = "insert into CustomersAccount values(?,?,?,?,?,?)";
					ArrayList<Object> parms = new ArrayList<Object>();
					
					String serialNo = createSerialNumber();
					String AccountNo = createAccountNumber(openNewAccount.getCustomerMobileNo(),openNewAccount.getCustomerName());
					
					parms.add(serialNo);
					parms.add(AccountNo);
					parms.add(openNewAccount.getCustomerMobileNo());
					parms.add(openNewAccount.getCustomerName());
					parms.add(openNewAccount.getCustomerAddress());
					parms.add(openNewAccount.getCustomerDepositAmount());

					rowInserted = template.update(query, parms.toArray());
				}catch(Exception e) {
					System.out.println("EXCEPTION :-" + e);
				}
				if(rowInserted==1) {
					return "Your Account Created Mrs/Mr " + openNewAccount.getCustomerName();
				}else {
					return "Error";
				}
				
	}
	
	//For Serial Number Creation
	private String createSerialNumber() {
		List<ListOfSerialNo> serailNos = new ArrayList<ListOfSerialNo>();
		try {
			String query = "Select SerialNo from CustomersAccount";
	        //row mapper created for getting the serial no
			serailNos = template.query(query, new ResultSetExtractor<List<ListOfSerialNo>>(){

				public List<ListOfSerialNo> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<ListOfSerialNo> serialNo = new ArrayList<ListOfSerialNo>();
					
					while(rs.next()) {
						ListOfSerialNo listOfSerialNo = new ListOfSerialNo();
						listOfSerialNo.setSerialNo(rs.getString("SerialNo"));
						serialNo.add(listOfSerialNo);
					}
					
					return serialNo;
				}
				
			});
		}catch(Exception e) {
			System.out.println("Error:-" + e);
		}
		
		String sNo = serailNos.get(serailNos.size()-1).getSerialNo();
		int newSNo = Integer.parseInt(sNo)+1;
		
		if(serailNos.size()>0) {
			return String.valueOf(newSNo);
		}else {
			return "1";
		}
	}
	
	//Creating Phone Number
	private String createAccountNumber(String pNo,String custName) {
		int key = custName.charAt(1);
		String stringAcc = pNo.substring(0, 5)  +  String.valueOf(key);
		return stringAcc;
	}
	
	//for showing account details
	public String showAccountNo(String phoneNo) {
		List<String> accountNo = new ArrayList<String>();
		try {
			String query = "Select AccountNo from CustomersAccount where CustMobileNumber=?";
			//row mapper created for getting the serial no
			accountNo = template.query(query, new ResultSetExtractor<List<String>>(){

				public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<String> accountNo = new ArrayList<String>();
					
					while(rs.next()) {
						accountNo.add(rs.getString("AccountNo"));
					}
					
					return accountNo;
				}
				
			},phoneNo);

		}catch(Exception e) {
			System.out.println("Hey You Got This Error" + e);
		}finally {
			System.out.println("Finally Block there!!!");
		}
		return accountNo.get(0);
	}
	
	//for withdrawing Balance
	public String amountWithdraw(String accNo, String balance) {
		String existingBalance = "";
				try {
					String queryFetchPreBalance = "select InitialDepositAmount from CustomersAccount where AccountNo=?";
					existingBalance = template.query(queryFetchPreBalance, new ResultSetExtractor<String>(){

						public String extractData(ResultSet rs) throws SQLException, DataAccessException {
							String accountNo = "";
							
							while(rs.next()) {
								accountNo= rs.getString("InitialDepositAmount");
							}
							
							return accountNo;
						}
						
					},accNo);
				}catch(Exception e) {
					System.out.println("You Have an error" + e);
				}
		
		
		return existingBalance;
	}

	public String updateAmount(String accNo, String balance) {
		int update = 0;
		try {
			
			String queryForUpdate = "UPDATE CustomersAccount SET InitialDepositAmount =? WHERE AccountNo =?";
			update = template.update(queryForUpdate,balance, accNo);
			
		}catch(Exception e) {
			System.out.println("Exception" + e);
		}
		if(update==1) {
			return "Yes";
		}else {
			return "No";
		}
	}
	
}
