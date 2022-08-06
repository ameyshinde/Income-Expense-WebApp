package com.inc.pojo;

public class Income {
	private double income;
	private int id;
	private String incomeType;
	private String incomeDate;
	private String description;
	private int userId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIncomeType() {
		return incomeType;
	}
	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}
	public String getIncomeDate() {
		return incomeDate;
	}
	public void setIncomeDate(String incomeDate) {
		this.incomeDate = incomeDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	
	
}
