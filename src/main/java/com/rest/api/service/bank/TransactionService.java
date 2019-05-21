package com.rest.api.service.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Component;

import com.rest.api.model.bank.Account;
import com.rest.api.model.bank.Transaction;

@Component
public class TransactionService {

	private static Map<Integer,Account> accountData=new HashMap<Integer, Account>();
	
	private static List<Transaction> transactionList = new ArrayList<Transaction>();
	private static Map<Integer,List<Transaction>> transMap = new HashMap<Integer, List<Transaction>>();
	
	public int  createTransactionObject(Transaction transaction) {
		try {
	
		int accountNo = transaction.getAccount().getAccountNumber();
				
		if(accountData!= null && accountData.containsKey(transaction.getAccount().getAccountNumber())) {
			double balance = accountData.get(accountNo).getAmount();
			double newbalance= 0.0;
			if(transaction.getDebitCredit().equalsIgnoreCase("credit"))
				 newbalance = balance + transaction.getAmount();
			else
				newbalance = balance - transaction.getAmount();
		
			transaction.getAccount().setAmount(newbalance);
		}else {
			transaction.getAccount().setAmount(transaction.getDebitCredit().equalsIgnoreCase("credit")?
					transaction.getAmount():transaction.getAmount()*(-1));
		}
		
		accountData.put(transaction.getAccount().getAccountNumber(),transaction.getAccount());
		transactionList.add(transaction);	
		
			if(!transMap.containsKey(transaction.getAccount().getAccountNumber())) {
			List<Transaction> newli = new ArrayList<Transaction>();
			newli.add(transaction);
			
		transMap.put(transaction.getAccount().getAccountNumber(),newli);
			}
			else {
				List<Transaction> accTransaction = new ArrayList<Transaction>();
				accTransaction = transMap.get(transaction.getAccount().getAccountNumber());
				accTransaction.add(transaction);
				transMap.put(transaction.getAccount().getAccountNumber(), accTransaction);
			}
		
		}
		catch(Exception e) {
			return 400;
		}
		return 200;
	}

	public List<Transaction> getTransactionObject() {
		
		return transactionList;
	}

	public List<Transaction> getTransactionForNumer(int number) {
		
		return transMap.get(number);
	}

	public Double getBalance(int number) {
		
		return accountData.get(number)!=null?accountData.get(number).getAmount():0.0;
	}
	
	
	
}
