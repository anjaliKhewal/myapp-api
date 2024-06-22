package com.rest.api.manager.bank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.api.model.bank.Transaction;
import com.rest.api.service.bank.TransactionService;



@Component
public class TransactionManger {
	@Autowired
	TransactionService service;
	
	public int createTransactionObject(Transaction transaction){
		
		return service.createTransactionObject(transaction);
		
	}
	
	public List<Transaction> getTransactionObject() {
		
		return service.getTransactionObject();
	}

	public List<Transaction> getTransactionForNumber(int number) {
		
		return service.getTransactionForNumer(number);
	}

	public Double getBalance(int number) {
	
		return service.getBalance(number);
	}

}
