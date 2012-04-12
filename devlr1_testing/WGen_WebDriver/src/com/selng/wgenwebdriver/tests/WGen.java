package com.selng.wgenwebdriver.tests;
import com.selng.wgenwebdriver.loginData.LoginData;

public class WGen extends LoginTest {
	
	public static final String SLI = "Shared Learning Infrastructure";
	public static final String NY = "New York Realm";
	public static final String IL = "Illinois Realm";
	
	public static void main(String[] args) throws Exception {
		
		LoginAdmin(SLI,LoginData.USERNAME_SLI_ADMIN,LoginData.PASSWORD_SLI_ADMIN);
		/*LoginNonAdmin(SLI,LoginData.USERNAME_SLI_NONADMIN,LoginData.PASSWORD_SLI_NONADMIN);
		LoginAdmin(NY,LoginData.USERNAME_NY_ADMIN,LoginData.PASSWORD_NY_ADMIN);
		LoginNonAdmin(NY,LoginData.USERNAME_NY_NONADMIN,LoginData.PASSWORD_NY_NONADMIN);
		LoginAdmin(IL,LoginData.USERNAME_IL_ADMIN,LoginData.PASSWORD_IL_ADMIN);
		LoginNonAdmin(IL,LoginData.USERNAME_IL_NONADMIN,LoginData.PASSWORD_IL_NONADMIN);*/
		
	}

}
