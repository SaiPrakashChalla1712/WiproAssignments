package com.proxyassignment;

public class ProxyImp implements Proxy {
	private final String secretKey="Sai@Rps@Wipro";

	public String getSecret(String password) {
		
		return secretKey;
	}

}
