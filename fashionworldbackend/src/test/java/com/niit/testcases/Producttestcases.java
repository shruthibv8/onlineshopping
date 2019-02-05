package com.niit.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;

public class Producttestcases {
static ProductDAO productDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();	
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductName("Forever21 brand clothes");
		product.setProductDesc("Forever21 brand everyday wear straight cut tops for women");
		product.setPrice(2500);
		product.setStock(15);
		product.setCategoryId(3);
		product.setSupplierId(1);
		
		assertTrue("Problem in Adding Product:",productDAO.addProduct(product));
	}

}
