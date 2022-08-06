package com.inc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.inc.pojo.Expense;
import com.inc.pojo.Income;
import com.inc.pojo.user;
import com.inc.util.DBConnect;

public class ExpenseDao {
	Connection con = DBConnect.getConnection();
	public Boolean addExpense(Expense inc )
	{
		String sql = ("insert into expense(expense,expense_type,description,user_id) values(?,?,?,?)");
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDouble(1, inc.getExpense());
			pst.setString(2, inc.getExpenseType());
			pst.setString(3,inc.getDescription());
			pst.setInt(4, inc.getUserId());
			int i = pst.executeUpdate();
			if(i>0)
				return true;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	return false;	
	}
	
	public List<Expense> getExpenseList(int uid){
		String sql ="select* from expense where user_id=?";
		List<Expense> explist = new ArrayList<Expense>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, uid);	
			ResultSet rst = pst.executeQuery();
			
			while(rst.next())
			{
				Expense exp =new Expense();
				exp.setId(rst.getInt("id"));
				exp.setExpense(rst.getDouble("expense"));
				exp.setExpenseDate(rst.getString("expense_date").toString());
				exp.setDescription(rst.getString("description"));
				exp.setExpenseType(rst.getString("expense_type"));
				exp.setUserId(rst.getInt("user_id"));
				explist.add(exp);
			}
			return explist;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public Boolean deleteExpense( int id )
	{
		String sql = ("delete from expense where id=?");
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			int i = pst.executeUpdate();
			if(i>0)
				return true;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
			
	return false;	
	}
	
	public Expense getExpense(int uid){
		String sql ="select * from expense where id=?";
		Expense inc =new Expense();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1 , uid);
			ResultSet rst = pst.executeQuery();
			
			while(rst.next())
			{
				
				inc.setId(rst.getInt("id"));
				inc.setExpense(rst.getDouble("expense"));
				inc.setExpenseDate(rst.getString("expense_date").toString());
				inc.setDescription(rst.getString("description"));
				inc.setExpenseType(rst.getString("expense_type"));
				inc.setUserId(rst.getInt("user_id"));
				return inc;
			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public Boolean updateExpense(Expense exp )
	{
		String sql = ("update  expense set expense=?,expense_type=?,description=?,user_id=? where id=?");
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDouble(1, exp.getExpense());
			pst.setString(2, exp.getExpenseType());
			pst.setString(3,exp.getDescription());
			pst.setInt(4, exp.getUserId());
			pst.setInt(5, exp.getId());
			int i = pst.executeUpdate();
			if(i>0)
				return true;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	return false;	
	}
	
	public List<Expense> getExpenseListByDescription(int uid,String description){
		String sql ="select* from expense where user_id=? and description like '%" + description + "%'";
		List<Expense> explist = new ArrayList<Expense>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1 , uid);
			ResultSet rst = pst.executeQuery();
			
			while(rst.next())
			{
				Expense exp =new Expense();
				exp.setId(rst.getInt("id"));
				exp.setExpense(rst.getDouble("expense"));
				exp.setExpenseDate(rst.getString("expense_date").toString());
				exp.setDescription(rst.getString("description"));
				exp.setExpenseType(rst.getString("expense_type"));
				exp.setUserId(rst.getInt("user_id"));
				explist.add(exp);
			}
			return explist;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Expense> getExpenseListByType(int uid,String type){
		String sql ="select* from expense where user_id=? and expense_type=? ";
		List<Expense> explist = new ArrayList<Expense>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1 , uid);
			pst.setString(2, type);
			ResultSet rst = pst.executeQuery();
			
			while(rst.next())
			{
				Expense exp =new Expense();
				exp.setId(rst.getInt("id"));
				exp.setExpense(rst.getDouble("expense"));
				exp.setExpenseDate(rst.getString("expense_date").toString());
				exp.setDescription(rst.getString("description"));
				exp.setExpenseType(rst.getString("expense_type"));
				exp.setUserId(rst.getInt("user_id"));
				explist.add(exp);
			}
			return explist;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}




