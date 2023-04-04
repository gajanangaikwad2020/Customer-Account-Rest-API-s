package com.customeraccount.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customeraccount.dao.AccountDao;
import com.customeraccount.entity.Account;
import com.customeraccount.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService
{
	@Autowired
	private AccountDao accountDao;
	 
	@Override
	public boolean addAccount(Account account) 
	{
//		Date date=new Date();
//		String currentDate = new SimpleDateFormat("yyyy:MM:dd:HH:MM:ss").format(new java.util.Date());
		account.setCreatedDate(new Date());
		
		return accountDao.addAccount(account);
	}

	@Override
	public boolean updateAccount(Account account) 
	{
		account.setCreatedDate(new Date());
		return accountDao.updateAccount(account);
	}

	@Override
	public Account getAccountById(int accId) 
	{
		return accountDao.getAccountById(accId);
	}

	@Override
	public List<Account> getAccountList() 
	{
		// TODO Auto-generated method stub
		return accountDao.getAccountList(); 
	}

	@Override
	public boolean deleteAccountById(int accId) 
	{
		return accountDao.deleteAccountById(accId); 
	}
	

}
