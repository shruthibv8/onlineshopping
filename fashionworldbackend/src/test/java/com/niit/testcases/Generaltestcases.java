package com.niit.testcases;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Generaltestcases {
	public static void main(String arg[])
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		context.refresh();
	}

}
