package com.test.service1.utils;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;


@Service
public class SessionService {

	@Autowired
	HttpSession httpSession;
	
	public<T> T get(String name) {
		if(httpSession.getAttribute(name)!= null) {
			return (T) httpSession.getAttribute(name);
		}
		return null;
	}
	
	public void set(String name, Object value) {
		httpSession.setAttribute(name, value);
	}
	
	public void remove(String name) {
		httpSession.removeAttribute(name);
	}
}
