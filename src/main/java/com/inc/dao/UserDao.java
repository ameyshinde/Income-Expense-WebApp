package com.inc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;

import com.inc.pojo.user;
import com.inc.util.DBConnect;

public class UserDao {
	
		Connection con = DBConnect.getConnection();
	public boolean addUser(String email, String Password)
	{
		String sql = "insert into user(email,password) values(?,?)";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, Password);
			int i = pst.executeUpdate();
			if(i>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public List<user> getUserList(){
		String sql ="Select* from user";
		List<user> ul= new ArrayList<user>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			while(rst.next())
			{
				user u =new user();
				u.setId(rst.getInt("id"));
				u.setName(rst.getString("name"));
				u.setEmail(rst.getString("email"));
				u.setContact(rst.getString("contact"));
				u.setPassword(rst.getString("password"));
				ul.add(u);
			}
			return ul;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public user userLogin(String email, String passw1) {
		String sql ="select * from user where email=? and password=?";
		user u  = new user();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, passw1);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setContact(rs.getString("contact"));
				u.setPassword(rs.getString("password"));
				return u;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;		
	}

	public boolean updateUser(user u)
	{
		String sql = "update user set name=?,email=?,contact=?,password=? where id=?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, u.getName());
			pst.setString(2, u.getEmail());
			pst.setString(3, u.getContact());
			pst.setString(4, u.getPassword());
			pst.setInt(5, u.getId());
			int i = pst.executeUpdate();
			if(i>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
}