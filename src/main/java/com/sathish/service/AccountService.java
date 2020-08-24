package com.sathish.service;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import com.sathish.model.Account;

public interface AccountService {

	boolean saveAccount(Account a) throws MessagingException, IOException;

	List<Account> getAllAccount();

	Account getAccountById(Integer id);

	boolean updateAccount(Account a);

	boolean deleteAccount(Integer id);
	
	public Account getUserAcctByTempPwd(String tempPwd);
	
}
