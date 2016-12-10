package com.atmlabs.humorizerbot.util;

import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class WebUtil {

	/*
	 * This method returns output of Http Method as String.
	 */
	public static String makeHttpCall(String sURI, HttpMethod httpMethod, Object data) {
		String sResponse = "";
		RestTemplate restTemplate = new RestTemplate();
		try {
			if (httpMethod == HttpMethod.GET) {
				sResponse = restTemplate.getForObject(sURI, String.class);
			} else if (httpMethod == HttpMethod.POST) {
				sResponse = restTemplate.postForObject(sURI, data, String.class);
			}
		} catch (Exception e) {
			System.out.println("Unable to make a REST call. " + e.getStackTrace());
		}

		return sResponse;
	}
}
