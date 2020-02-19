package br.com.rocketAirlines.util;

import java.io.IOException;

import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

public class WebHelper {
	
	public static String PostJson(String url, String body) throws IOException {
		return Request
				.Post(url)
				.bodyString(body, ContentType.APPLICATION_JSON)
				.execute()
				.returnContent()
				.asString();
	}
	
	public static String GetJson(String url) throws IOException {
		return Request
				.Get(url)
				.execute()
				.returnContent()
				.asString();
	}
	
}
