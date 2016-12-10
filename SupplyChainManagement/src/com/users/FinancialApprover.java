package com.users;
import com.interfaces.MakeDecision;
import com.items.PurchaseOrder;
import com.items.Request;
import com.model.Account;
import com.model.Stock;

//@invariant("id != null")

public class FinancialApprover extends User implements MakeDecision {

	public FinancialApprover(String name, String password, String email) {
		super(name, password, email);
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}
	
	//@requires (accounts[] != null)
	//@ensures (account.balance > price) 
	
	private Account selectAccount(Account[] accounts, double price)
	{
		Account account = null;
		for(Account acc: accounts)
		{
			if(acc.getBalance() >= price)
			{
				account = acc;
				break;
			}	
		}
		return account;
	}
	
	public PurchaseOrder checkRequest(Request request, Account[] accounts) {
		double price = 0;
		PurchaseOrder PO = null;
		for(Stock s : request.getProductList()) {
			price += s.getQuantity() * s.getProduct().getPrice();
		}
		Account account = this.selectAccount(accounts, price);
		
		if(account!= null && request.getRequestStatus() == 1)
		{
			approveRequest(request);
			PO = generatePO(request);
			account.setBalance(account.getBalance()-price);
		}
		else
			rejectRequest(request);
		return PO;
	}
	//@requires (request.status = 1)
	//@ensures (PO != null)
	
	private PurchaseOrder generatePO(Request request)
	{
		PurchaseOrder PO = new PurchaseOrder(request);
		return PO;
	}
	@Override
	//@requires (request.getRequestedStatus() = 1)
	//@ensures (request.getRequestedStatus() = 2)
	
	public void approveRequest(Request request) {
		request.setRequestStatus(2);
		PurchaseOrder PO = generatePO(request);
		System.out.println("Request " + request.getID() + " from " + request.getRequesterName() + " approved by Approver: " + this.getName() + " and PO no "+PO.getID()+" is generated");
	}
	//@requires (request.getRequestedStatus() = 1)
	//@ensures (request.getRequestedStatus() = 0)
	
	@Override
	public void rejectRequest(Request request) {
		request.setRequestStatus(0);
		System.out.println("Request " + request.getID() + " from " + request.getRequesterName() + " rejected by Approver: " + this.getName() + " due to insufficient balance");
	}
}
