package com.test.service1.utils;

import com.google.gson.Gson;

public class JsonConversion<T> {
	
	private T t;
	
	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public JsonConversion(T t) {
		this.t = t;
	}
	
	public String ObjectToString() {
		Gson gson = new Gson();
		return gson.toJson(t);
	}
	
	public T StringToObject(String jsonString, Class<T> tt) {
		Gson gson = new Gson();
		return gson.fromJson(jsonString, tt);
	}
	
	
}
