package com.customeraccount.service;

import java.util.List;

import com.customeraccount.entity.Account;

public interface AccountService 
{

	public boolean addAccount(Account account);

	public boolean updateAccount(Account account);

	public Account getAccountById(int accId);

	public List<Account> getAccountList();

	public boolean deleteAccountById(int accId);
	

}
