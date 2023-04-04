package com.customeraccount;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.customeraccount.dao.AccountDao;
import com.customeraccount.entity.Account;
import com.customeraccount.service.AccountService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerAccountRestApiApplicationTests 
{
	@Autowired
	private AccountService accountService;
	
	@MockBean
	private AccountDao accountDao;
	
	@Test
	@Order(1)
	public void testSaveAccount() 
	{
		Account accountTest=new Account(0, 25506, "Nanded", "SBIN5503", 60000,null);
		accountService.addAccount(accountTest);
		assertNotNull(accountDao.getAccountById(6));
	}

}
