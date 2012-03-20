package com.selng.wgen.tests;

import org.testng.*;
import org.testng.annotations.Test;
import com.selng.wgen.loginData.LoginData;
import com.selng.wgen.utils.BasicLogin;

public class LoginTest extends CommonTest
{
	@Test(groups={"sanity"})
	
	public void LoginAdmin() throws Exception
	{
		Assert.assertTrue(BasicLogin.login(LoginData.username_admin.get(),
		LoginData.password_admin.get()));
		
		Assert.assertTrue(sel.isElementPresent("css=a[href='/web/guest/admin']"));
		BasicLogin.logout();
		
	}
	@Test(groups={"sanity"})
	
	public void LoginNonAdmin() throws Exception
	{
		Assert.assertTrue(BasicLogin.login(LoginData.username_nonadmin.get(),
		LoginData.password_nonadmin.get()));	
		
		Assert.assertFalse(sel.isElementPresent("css=a[href='/web/guest/admin']"));		
		BasicLogin.logout();
	}
}
