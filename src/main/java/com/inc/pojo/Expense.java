package com.inc.pojo;

public class Expense {
	private double expense;
	private String expenseType;
	private String expenseDate;
	private String description;
	private int id;
	private int userId;
	public double getExpense() {
		return expense;
	}
	public void setExpense(double expense) {
		this.expense = expense;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getExpenseDate() {
		return expenseDate;
	}
	public void setExpenseDate(String expenseDate) {
		this.expenseDate = expenseDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String desciption) {
		this.description = desciption;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Expense [expense=" + expense + ", expenseType=" + expenseType + ", expenseDate=" + expenseDate
				+ ", description=" + description + ", id=" + id + ", userId=" + userId + "]";
	}
	
}
