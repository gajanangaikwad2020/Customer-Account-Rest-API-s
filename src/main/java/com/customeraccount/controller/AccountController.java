package com.customeraccount.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customeraccount.entity.Account;
import com.customeraccount.exception.ResourceAlreadyExistException;
import com.customeraccount.exception.ResourceNotFoundException;
import com.customeraccount.service.AccountService;


@RestController
@RequestMapping(value = "/acc")
public class AccountController 
{
	@Autowired
	private AccountService accountService;

	@PostMapping("/add-account")
	public ResponseEntity<String> addAccount(@RequestBody Account account)
	{	
		boolean isSaved= accountService.addAccount(account);
		if(isSaved)
		{
			return new ResponseEntity<String>("New Account is Created.",HttpStatus.CREATED);
		}
		else
		{
			throw new ResourceAlreadyExistException("Account is Already Exist with this account id ->"+ account.getAccountId());
		}
		
	}
	
	@PutMapping("/update-account")
	public ResponseEntity<String> updateAccount(@RequestBody Account account)
	{
		boolean isUpdated= accountService.updateAccount(account);
		if(isUpdated)
		{
			return new ResponseEntity<String>("New Account is Updated.",HttpStatus.CREATED);
		}
		else
		{
			throw new ResourceNotFoundException("Account does Not Exist with this account id ->"+ account.getAccountId());
		}
		
	}
	
	@GetMapping("/get-account-by-id/{accId}")
	public ResponseEntity<Account> getAccountById(@PathVariable int accId )
	{
		Account account=accountService.getAccountById(accId);
		if(account!=null)
		{		
			return new ResponseEntity<Account>(account,HttpStatus.OK);
		}
		else
		{
			throw new ResourceNotFoundException("Account does Not Exist with this account id ->"+ accId);
		}		
	}
	
	@GetMapping("/get-account-list")
	public ResponseEntity<List<Account>> getAccountList()
	{
		List<Account> accountList=accountService.getAccountList();
		if(!accountList.isEmpty())
		{
			return new ResponseEntity<List<Account>>(accountList,HttpStatus.OK);
		}
		else
		{
			throw new ResourceNotFoundException("Account List is Empty.");
		}	
	}
	
	@DeleteMapping("/delete-account-by-id/{accId}")
	public ResponseEntity<String> deleteAccountById(@PathVariable int accId )
	{
		boolean isDeleted=accountService.deleteAccountById(accId);
		if(isDeleted)
		{
			return new ResponseEntity<String>("Account is Deleted with account Id -> "+accId,HttpStatus.OK);
		}
		else
		{
			throw new ResourceNotFoundException("Account does Not Exist with this account id ->"+ accId);
		}		
	}
}
