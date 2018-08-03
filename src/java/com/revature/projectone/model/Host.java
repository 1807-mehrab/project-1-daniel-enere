package com.revature.projectone.model;

public class Host {
	private String hostName;
	private String hostTitle;
	private String hostEmail;
	private String hostPassword;
	
	public Host() {
		super();
	}
	
	public Host(String hostName, String hostTitle, String hostEmail) {
		this();
		this.hostName = hostName;
		this.hostTitle = hostTitle;
		this.hostEmail = hostEmail;
	}

	public String getHostName() {
		return hostName;
	}
	public String getHostTitle() {
		return hostTitle;
	}
	public String getHostEmail() {
		return hostEmail;
	}
	public String getHostPassword() {
		return hostPassword;
	}
	
	public void setHostPassword(String password) {
		this.hostPassword = password;
	}

	@Override
	public String toString() {
		return "Host [hostName=" + hostName + ", hostTitle=" + hostTitle + ", hostEmail=" + hostEmail + "]\n";
	}
}
