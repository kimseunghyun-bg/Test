package com.lsitc.sfc.dspsample.common.login.vo;

public class LoginVO {
	private static final long serialVersionUID = 1L;

    private String username;         
    private String password;  
    private String accessToken;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
    
    
}
