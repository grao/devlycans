package com.selng.wgen.loginData;

public enum LoginData
{
	username_admin("demo"),
	password_admin("changeit"),
	username_nonadmin("educator"),
	password_nonadmin("educator1234");
	
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