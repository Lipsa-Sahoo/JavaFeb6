package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.CustomListener;

@Listeners(CustomListener.class)
public class GooglePageTest extends TestBase{
	
	public GooglePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
		@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
