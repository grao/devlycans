package com.selng.wgenwebdriver.loginData;

public enum LoginData
{
	USERNAME_SLI_ADMIN("demo"),
	PASSWORD_SLI_ADMIN("changeit"),
	USERNAME_SLI_NONADMIN("educator"),
	PASSWORD_SLI_NONADMIN("educator1234"),
	USERNAME_NY_ADMIN(""),
	PASSWORD_NY_ADMIN(""),
	USERNAME_NY_NONADMIN("mario.sanchez"),
	PASSWORD_NY_NONADMIN("mario.sanchez1234"),
	USERNAME_IL_ADMIN(""),
	PASSWORD_IL_ADMIN(""),
	USERNAME_IL_NONADMIN("jdoe"),
	PASSWORD_IL_NONADMIN("jdoe1234"),
	;
	private final String name;
	
	LoginData(String name)
	{
		this.name = name;
	}
	
	public String get()
	{
		return name;
	}
	
}