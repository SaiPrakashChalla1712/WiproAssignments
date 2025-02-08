package com.proxyassignment;

public class PasswordCheck implements Proxy {
	private ProxyImp proxyObj;
	private final String authPassword="Rps@123";

	public String getSecret(String password) {
		if(password.equals(authPassword)) {
			if(proxyObj==null) {
				proxyObj=new ProxyImp();
			}
			return proxyObj.getSecret(password);
		}
		return null;
	}

}
