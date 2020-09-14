package com.testing.sender.springsenderapp.model;

public class Swift extends ParentMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String bank;

	private String country;

	private String location;

	private String branch;

	public Swift() {
		super();
	}

	public Swift(String bank, String country, String location, String branch) {
		super();
		this.bank = bank;
		this.country = country;
		this.location = location;
		this.branch = branch;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Swift [bank=" + bank + ", country=" + country + ", location=" + location + ", branch="
				+ branch + "]";
	}

}
