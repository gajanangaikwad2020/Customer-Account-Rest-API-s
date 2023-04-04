package com.customeraccount.dao;

import java.util.List;

import com.customeraccount.entity.Account;

public interface AccountDao 
{

	boolean addAccount(Account account);

	boolean updateAccount(Account account);

	Account getAccountById(int accId);

	List<Account> getAccountList();

	boolean deleteAccountById(int accId);
	

}
