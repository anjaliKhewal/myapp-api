package com.rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.manager.bank.TransactionManger;
import com.rest.api.model.bank.Transaction;



@RestController
@RequestMapping("/mybank")
public class BankController {
	
	@Autowired
	TransactionManger manager;
	
	
	@RequestMapping(value ="/getbalance", method=RequestMethod.GET, headers="Accept=*/*",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Double getBalance(@RequestParam int number) {
		
		return manager.getBalance(number);
	}

	@RequestMapping(value="/gettransactions", method=RequestMethod.GET, headers="Accept=*/*", 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> getTransactions(){
		
		return manager.getTransactionObject();
	}
	
	@RequestMapping(value="/gettransactionaccount", method=RequestMethod.GET, headers="Accept=*/*", 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> getTransactionForAccount(@RequestParam int number){
		
		return manager.getTransactionForNumber(number);
	}
	
	@RequestMapping(value="/posttransaction", method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Integer postTransaction(@RequestBody Transaction transaction) {
		
		return manager.createTransactionObject(transaction);
	
	}
}
