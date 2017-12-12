package com.compsys.cookie;

import java.util.ArrayList;

import javax.servlet.http.Cookie;

import com.compsys.model.User;

public class Cookies {
	public static ArrayList<String> list = new ArrayList<String>();
	public static final String CookieLogin = "AuthorytyLogin";
	public static final String CookieSettings = "AuthorytySetting";
	public static String CookieValue = null;
	static  
	{
		list.add(CookieLogin);
		list.add(CookieSettings);
		
	}
	
	
}
