package com.users;

import com.items.PurchaseOrder;
import com.model.Stock;

//@invariant("id != null")

public class Supplier extends User {

	private Stock listOfProducts[];
	
	public Supplier(String name, String password, String email, Stock[] products) {
		super(name, password, email);
		listOfProducts = products;
	}
	
	public Stock[] getListOfProducts() {
		return listOfProducts;
	}
	
	public void listStock(Stock product, int stock) {
		boolean flag = false;
		for(Stock s : listOfProducts) {
			if(s.getProduct().getType().compareTo(product.getProduct().getType()) == 0) {
				s.setStock(stock);
				flag = true;
			}
		}
		if(!flag)
			System.out.println("Product:" + product.getProduct().getType() + " could not be found!");
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}
	
	public void checkPO(PurchaseOrder PO) {
		int flag = 0;
		if(PO.getStatus() == 0)
		{
			System.out.println("PO has been received from Financial Approver and is ready to ship");
			for(Stock userStock: PO.getRequestItems().getProductList())
			{
				for(Stock supplierStock: getListOfProducts())
				{
					if(userStock.getProduct().getType().compareTo(supplierStock.getProduct().getType()) == 0)
					{
						if(userStock.getQuantity() > supplierStock.getQuantity())
							flag = 1;
					}
				}
			}
			if(flag == 0)
			{
				approvePO(PO);
			}
			else
				rejectPO(PO);
		}
		return;
	}
	
	//@requires (userStock.getQuantity() < supplierStock.getQuantity())
	//@ensures (supplier.quantity = supplierStock.getQuantity() - userStock.getQuantity() 
	
	public void approvePO(PurchaseOrder PO) {
		PO.setStatus(1);
		for(Stock userStock: PO.getRequestItems().getProductList())
		{
			for(Stock supplierStock: getListOfProducts())
			{
				if(userStock.getProduct().getType().compareTo(supplierStock.getProduct().getType()) == 0)
				{
					supplierStock.setStock(supplierStock.getQuantity() - userStock.getQuantity());
				}
			}
		}
		System.out.println("PO has been successfully shipped by the supplier "+this.getName()+"\n");
	}
	//@requires (userStock.getQuantity() > supplierStock.getQuantity())
	//@ensures  (PO status = 2)
	public void rejectPO(PurchaseOrder PO)
	{
		PO.setStatus(2);
		System.out.println("PO has been rejected by supplier "+this.getName()+" due to insufficient quqntity \n");
	}
}
