package com.customeraccount.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customeraccount.dao.AccountDao;
import com.customeraccount.entity.Account;

@Repository
public class AccountDaoImpl implements AccountDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addAccount(Account account) 
	{
		
		boolean isAdded=false;
		try 
		{
			Session session = sessionFactory.openSession();
			Account dbaccount = session.get(Account.class, account.getAccountId());
			if(dbaccount==null)
			{
				Transaction transaction = session.beginTransaction();
				session.save(account);
				transaction.commit();
				isAdded=true;
			}	
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
		return isAdded;
	}

	@Override
	public boolean updateAccount(Account account) {
		boolean isUpdated=false;
		try 
		{
			Session session = sessionFactory.openSession();
			Account account2 = session.get(Account.class, account.getAccountId());
			
			if(account2!=null)
			{
//				Session session2 = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				session.update(account);
				transaction.commit();
				isUpdated=true;
			}	
			else
			{
				isUpdated=false;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
		return isUpdated;
	}

	@Override
	public Account getAccountById(int accId) 
	{
		Account account=null;
		try 
		{
			Session session = sessionFactory.openSession();
			account = session.get(Account.class, accId);	
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
		return account;
	}

	@Override
	public List<Account> getAccountList() 
	{
		List<Account> accountList=null;
		try 
		{
			Session session = sessionFactory.openSession();
//			Criteria criteria = session.createCriteria(Account.class);	//Using Criteria
//			accountList = criteria.list();
			
			Query query = session.createQuery("from Account");	//Using Query
			accountList = query.list();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
		return accountList;
	}

	@Override
	public boolean deleteAccountById(int accId) 
	{
		boolean isDeleted=false;
		try 
		{
			Session session = sessionFactory.openSession();
			Account account = session.get(Account.class, accId);
			if (account!=null) 
			{
				Transaction transaction = session.beginTransaction();
				session.delete(account);
				transaction.commit();
				isDeleted=true;
			}	
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return isDeleted;
	}
	
	

}
