 package com.inc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.inc.pojo.Income;
import com.inc.util.DBConnect;

public class IncomeDao {
	Connection con = DBConnect.getConnection();
	public Boolean addIncome(Income inc )
	{
		String sql = ("insert into income(income,income_type,description,user_id) values(?,?,?,?)");
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDouble(1, inc.getIncome());
			pst.setString(2, inc.getIncomeType());
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
	
	public List<Income> getIncomeList(int uid){
		String sql ="select* from income where user_id=?";
		List<Income> inclist = new ArrayList<Income>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1 , uid);
			ResultSet rst = pst.executeQuery();
			
			while(rst.next())
			{
				Income inc =new Income();
				inc.setId(rst.getInt("id"));
				inc.setIncome(rst.getDouble("income"));
				inc.setIncomeDate(rst.getString("income_date").toString());
				inc.setDescription(rst.getString("description"));
				inc.setIncomeType(rst.getString("income_type"));
				inc.setUserId(rst.getInt("user_id"));
				inclist.add(inc);
			}
			return inclist;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

public Boolean deleteIncome( int id )
{
	String sql = ("delete from income where id=?");
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

public Income getIncome(int uid){
	String sql ="select* from income where id=?";
	Income inc =new Income();
	try {
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1 , uid);
		ResultSet rst = pst.executeQuery();
		
		while(rst.next())
		{
			
			inc.setId(rst.getInt("id"));
			inc.setIncome(rst.getDouble("income"));
			inc.setIncomeDate(rst.getString("income_date").toString());
			inc.setDescription(rst.getString("description"));
			inc.setIncomeType(rst.getString("income_type"));
			inc.setUserId(rst.getInt("user_id"));
			return inc;
		}

	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
}

public Boolean updateIncome(Income inc )
{
	String sql = ("update  income set income=?,income_type=?,description=?,user_id=? where id=?");
	try {
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setDouble(1, inc.getIncome());
		pst.setString(2, inc.getIncomeType());
		pst.setString(3,inc.getDescription());
		pst.setInt(4, inc.getUserId());
		pst.setInt(5, inc.getId());
		int i = pst.executeUpdate();
		if(i>0)
			return true;
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
return false;	
}

	public List<Income> getIncomeListByDescription(int uid,String description){
	String sql ="select* from income where user_id=? and description like '%" + description + "%'";
	List<Income> inclist = new ArrayList<Income>();
	try {
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1 , uid);
		ResultSet rst = pst.executeQuery();
		
		while(rst.next())
		{
			Income inc =new Income();
			inc.setId(rst.getInt("id"));
			inc.setIncome(rst.getDouble("income"));
			inc.setIncomeDate(rst.getString("income_date").toString());
			inc.setDescription(rst.getString("description"));
			inc.setIncomeType(rst.getString("income_type"));
			inc.setUserId(rst.getInt("user_id"));
			inclist.add(inc);
		}
		return inclist;
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
}

	public List<Income> getIncomeListByType(int uid,String type){
	String sql ="select* from income where user_id=? and income_type =?";
	List<Income> inclist = new ArrayList<Income>();
	try {
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1 , uid);
		pst.setString(2, type);
		ResultSet rst = pst.executeQuery();
		
		while(rst.next())
		{
			Income inc =new Income();
			inc.setId(rst.getInt("id"));
			inc.setIncome(rst.getDouble("income"));
			inc.setIncomeDate(rst.getString("income_date").toString());
			inc.setDescription(rst.getString("description"));
			inc.setIncomeType(rst.getString("income_type"));
			inc.setUserId(rst.getInt("user_id"));
			inclist.add(inc);
		}
		return inclist;
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
}
	
	public double getBalance(int userId) {
		String sql1 = "Select sum(income) as totalIncome from income where user_id="+userId;
		try {
			PreparedStatement pst1 = con.prepareStatement(sql1);
			ResultSet rst1 = pst1.executeQuery();
			if(rst1.next()) {
				double totalIncome = rst1.getDouble("totalIncome");
				String sql2 = "Select sum(expense) as totalExpense from expense where user_id="+userId;
				PreparedStatement pst2 = con.prepareStatement(sql2);
				ResultSet rst2 = pst2.executeQuery();
				if(rst2.next())
				{
					double totalExpense = rst2.getDouble("totalExpense");
					return totalIncome-totalExpense;
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();	}
		
		return 0;
	}
}