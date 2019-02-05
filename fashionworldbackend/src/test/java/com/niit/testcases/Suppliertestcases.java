package com.niit.testcases;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

public class Suppliertestcases {
static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();	
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}
	
	@Test
	public void addSupplierTest() 
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName("Tunics");
		supplier.setSupplierAddr("Hyderabad");		
		assertTrue("Problem in adding Supplier",supplierDAO.addSupplier(supplier));
	}
	@Ignore
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(1);
		assertTrue("Problem in Deleting Supplier:",supplierDAO.deleteSupplier(supplier));
	}
    @Ignore
	@Test
	public void updateSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(2);
		supplier.setSupplierAddr("Long Cardigans");
		assertTrue("Problem in Updating the Supplier",supplierDAO.updateSupplier(supplier));
	}
	
	@Test
	public void listCategoriesTest()
	{
		List<Supplier> listCategories=supplierDAO.listSuppliers();
		assertTrue("Problem in Listing Categories:",listCategories.size()>0);
		
		for(Supplier supplier:listCategories)
		{
			System.out.println("Supplier ID:"+supplier.getSupplierId());
			System.out.println("Supplier Name:"+supplier.getSupplierName());
			System.out.println("Supplier Desc:"+supplier.getSupplierAddr());
		}
	}

}