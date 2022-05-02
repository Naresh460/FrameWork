/**
 * 
 */
package com.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseclass.Base;
import com.dataProvider.DataProviders;
import com.pageobjects.AccountCreationPage;
import com.pageobjects.IndexPage;
import com.pageobjects.LoginPage;

/**
 * @author nbusireddy
 *
 */
public class AccountCreationTest extends Base{
	
	IndexPage indexpage;
	LoginPage loginpage;
	AccountCreationPage accountcreationpage;

//	@Parameters({"browserrname","Smoke","Sanity"})
//	@BeforeMethod 
//	public void browsersetup(String browserrname) {
//		launchApp(browserrname);		
//	}
//	
//	@AfterTest
//	public void teardown() {
//		getDriver().quit();
//	}
	
	@Test (dataProvider = "email" , dataProviderClass = DataProviders.class)
	public void navigatetoCreateAccount(String email) {
		indexpage = new IndexPage();		
		loginpage = indexpage.clickonsign();
		accountcreationpage = loginpage.createNewAccount(email);
		boolean result = accountcreationpage.createAccountHeader();
		Assert.assertTrue(result);
		
		
	}
	public void createAccount(HashMap<String, String> hasMapValue) {
		indexpage = new IndexPage();		
	loginpage = indexpage.clickonsign();
	accountcreationpage = loginpage.createNewAccount(hasMapValue.get("Email"));
//	accountcreationpage.
	}
}
