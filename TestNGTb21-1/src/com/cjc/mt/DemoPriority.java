package com.cjc.mt;

import org.testng.annotations.Test;

public class DemoPriority
{

	@Test(priority =1)
	public void add()
	{
		System.out.println("Addition");
	}
	
	@Test(priority = 1)
	public void sub()
	{
		System.out.println("Subtraction");
	}
	
	@Test(priority =0)
	public void multi()
	{
		System.out.println("Multi");
	}
	
	@Test
	public void div()
	{
		System.out.println("Div");
	}
	
}
