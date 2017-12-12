package com.compsys.cookie;

import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.compsys.model.User;

public class CookieCheck {

	public  static boolean checkIfExistsCookie(HttpServletRequest request, String cookieName) 
	{
		Cookie[] cookies = request.getCookies();

		if (cookies != null) 
		{
		 for (Cookie cookie : cookies) 
		 {
			 String ActualCookieName = cookie.getName();
			 String ActualCookieValue = cookie.getValue();
			 
		   if (Objects.equals(ActualCookieName, cookieName) && Objects.equals(ActualCookieValue, Cookies.CookieValue)) 
		   {
		     return true;
		   }
		  }
		 return false;
		}
		else
		{
			return false;
		}
		
	}
	
	public  static Cookie createLoginCookie(User user) 
	{
		//TODO udělat lépe
		//create cookie
		String cookieValue = Long.toString(user.getId());
		Cookie cookieAuthority = new Cookie(Cookies.CookieLogin, cookieValue); //bake cookie
		cookieAuthority.setMaxAge(10000); //set expire time
		Cookies.CookieValue = cookieValue;
		return cookieAuthority;
	}
	
	
	public  static Cookie deleteLoginCookie() 
	{
		Cookie cookieAuthority = new Cookie(Cookies.CookieLogin, ""); //bake cookie
		cookieAuthority.setMaxAge(0); //set expire time
		Cookies.CookieValue = null;
		return cookieAuthority;
	}
	
}
