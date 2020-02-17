package br.com.rocketAirlines.util;

import com.google.gson.Gson;

public class JsonConverter {
	
	public static String toJson(Object obj) {
		return new Gson().toJson(obj);
	}
	
	public static <T> T fromJson(String json, Class<T> classe) {
		return new Gson().fromJson(json, classe);
	}

	
}
