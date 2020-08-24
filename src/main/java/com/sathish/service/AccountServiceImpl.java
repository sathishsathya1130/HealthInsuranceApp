package com.sathish.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathish.constants.AppConstants;
import com.sathish.entity.AccountEntity;
import com.sathish.model.Account;
import com.sathish.repo.AccountRepository;
import com.sathish.utils.EmailUtils;
import com.sathish.utils.PwdUtils;


@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository AccountRepo;

	@Autowired
	private EmailUtils emailUtils;
	
	/*
	 * @Autowired private PwdUtils pwdutils;
	 */

	@Override
	public boolean saveAccount(Account account) throws MessagingException, IOException {
		/* boolean issaved = false; */
		account.setPwd(PwdUtils.generateTempPwd(AppConstants.TEMP_PWD_LENGTH));
		account.setAccStatus(AppConstants.LOCKED_STR);

		AccountEntity entity = new AccountEntity();
		BeanUtils.copyProperties(account, entity);

		AccountEntity savedEntity = AccountRepo.save(entity);

		if (savedEntity.getId() != null) {
			return emailUtils.sendAccountUnlockMail(account);

		}
		return false;
	}

	@Override
	public List<Account> getAllAccount() {

		List<Account> accounts = new ArrayList<Account>();
		List<AccountEntity> EntityList = AccountRepo.findAll();

		EntityList.forEach(entity -> {
			Account a = new Account();
			BeanUtils.copyProperties(entity, a);
			accounts.add(a);

		});

		return accounts;
	}

	@Override
	public Account getAccountById(Integer id) {
		Optional<AccountEntity> findById = AccountRepo.findById(id);
		if (findById.isPresent()) {
			AccountEntity entity = findById.get();
			Account a = new Account();
			BeanUtils.copyProperties(entity, a);
			return a;
		}

		return null;
	}

	@Override
	public boolean updateAccount(Account a) {
		return false;
	}

	@Override
	public boolean deleteAccount(Integer id) {
		AccountRepo.deleteById(id);
		return false;
	}

	@Override
	public Account getUserAcctByTempPwd(String tempPwd) {
		AccountEntity entity = new AccountEntity();
		Account acct = null;

		if (entity != null) {
			acct = new Account();
			BeanUtils.copyProperties(entity, acct);
		}
		return acct;

	}

}
