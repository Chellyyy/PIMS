package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.User;

public class UserDao{
	public void addUser(User u){
	Connection conn=util.JdbcUtil.getConnection();
	try {
		String sql="insert into User(username,password,name,sex,year,month)values(?,?,?,?,?,?)";
		PreparedStatement p=conn.prepareStatement(sql);
		p.setString(1, u.getUsername());
		p.setString(2, u.getPassword());
		p.setString(3, u.getName());
		p.setString(4, u.getSex());
		p.setString(5, u.getYear());
		p.setString(6, u.getMonth());
		p.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public boolean findByPrint(String username,String password){
		Connection conn=util.JdbcUtil.getConnection();
		String sql="select username,password from user where username=? and password=?";
		try {
			PreparedStatement p=conn.prepareStatement(sql);
			p.setString(1, username);
			p.setString(2, password);
			ResultSet result=p.executeQuery();
			if(result.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public boolean findByUser(String username){
		Connection conn=util.JdbcUtil.getConnection();
		String sql="select username,password from user where username=?";
		try {
			PreparedStatement p=conn.prepareStatement(sql);
			p.setString(1, username);
			ResultSet result=p.executeQuery();
			if(result.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public  List<User> findById(int userid){
		Statement stmt=null;
		ResultSet rs=null;
		User User=null;
		List<User> UserI=new ArrayList<User>();
		Connection conn=util.JdbcUtil.getConnection();
		String sql="select * from user where userid=?";
		try {
			stmt=conn.createStatement();
			PreparedStatement p=conn.prepareStatement(sql);
			p.setInt(1, userid);
			rs=p.executeQuery();
			while(rs.next()){
				 User=new User();
				 User.setUserid(rs.getInt(1));
				 User.setUsername(rs.getString(2));
				 User.setPassword(rs.getString(3));
				 User.setName(rs.getString(4));
				 User.setSex(rs.getString(5));
				 User.setYear(rs.getString(6));
				 User.setMonth(rs.getString(7));
				 UserI.add(User);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return UserI;
	}
	public  List<User> findAll(String username,String password){
		Statement stmt=null;
		ResultSet rs=null;
		User User=null;
		List<User> UserI=new ArrayList<User>();
		Connection conn=util.JdbcUtil.getConnection();
		String sql="select * from user where username=? and password=?";
		try {
			stmt=conn.createStatement();
			PreparedStatement p=conn.prepareStatement(sql);
			p.setString(1, username);
			p.setString(2, password);
			rs=p.executeQuery();
			while(rs.next()){
				 User=new User();
				 User.setUserid(rs.getInt(1));
				 User.setUsername(rs.getString(2));
				 User.setPassword(rs.getString(3));
				 User.setName(rs.getString(4));
				 User.setSex(rs.getString(5));
				 User.setYear(rs.getString(6));
				 User.setMonth(rs.getString(7));
				 UserI.add(User);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return UserI;
	}
	public void UpdateUser(User u){
	Connection conn=util.JdbcUtil.getConnection();
	try {
		String sql="update user set password=?,name=?,sex=?,year=?,month=? where userid=?";
		PreparedStatement p=conn.prepareStatement(sql);
		
		p.setString(1, u.getPassword());
		p.setString(2, u.getName());
		p.setString(3, u.getSex());
		p.setString(4, u.getYear());
		p.setString(5, u.getMonth());
		p.setInt(6, u.getUserid());
		p.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
