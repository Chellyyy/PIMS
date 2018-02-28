package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Income;

public class IncomeDao {
	public void addIncome(Income m){
	Connection conn=util.JdbcUtil.getConnection();
	try {
		String sql="insert into income(time,item,money,userid)values(?,?,?,?)";
		PreparedStatement p=conn.prepareStatement(sql);
		p.setString(1, m.getTime());
		p.setString(2, m.getItem());
		p.setFloat(3, m.getMoney());
		p.setInt(4, m.getUserid());
		p.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public  List<Income> selectByIncomeid(int incomeid){
		Statement stmt=null;
		ResultSet rs=null;
		Income Income=null;
		List<Income> IncomeI=new ArrayList<Income>();
		Connection conn=util.JdbcUtil.getConnection();
		String sql="select * from income where incomeid=?";
		try {
			stmt=conn.createStatement();
			PreparedStatement p=conn.prepareStatement(sql);
			p.setInt(1, incomeid);
			rs=p.executeQuery();
			while(rs.next()){
				 Income=new Income();
				 Income.setIncomeid(rs.getInt(1));
				 Income.setTime(rs.getString(2));
				 Income.setItem(rs.getString(3));
				 Income.setMoney(rs.getFloat(4));
				 Income.setUserid(rs.getInt(5));
				 IncomeI.add(Income);
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
		return IncomeI;
	}
	public  List<Income> findById(int userid){
		Statement stmt=null;
		ResultSet rs=null;
		Income Income=null;
		List<Income> IncomeI=new ArrayList<Income>();
		Connection conn=util.JdbcUtil.getConnection();
		String sql="select * from income where userid=?";
		try {
			stmt=conn.createStatement();
			PreparedStatement p=conn.prepareStatement(sql);
			p.setInt(1, userid);
			rs=p.executeQuery();
			while(rs.next()){
				 Income=new Income();
				 Income.setIncomeid(rs.getInt(1));
				 Income.setTime(rs.getString(2));
				 Income.setItem(rs.getString(3));
				 Income.setMoney(rs.getFloat(4));
				 Income.setUserid(rs.getInt(5));
				 IncomeI.add(Income);
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
		return IncomeI;
	}

	public void UpdateIncome(Income i){
	Connection conn=util.JdbcUtil.getConnection();
	try {
		String sql="update income set time=?,item=?,money=? where incomeid=?";
		PreparedStatement p=conn.prepareStatement(sql);
		
		p.setString(1, i.getTime());
		p.setString(2, i.getItem());
		p.setFloat(3, i.getMoney());
		p.setInt(4, i.getIncomeid());
		p.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	public void DeleteIncome(Income i){
	Connection conn=util.JdbcUtil.getConnection();
	try {
		String sql="delete from income where incomeid=?";
		PreparedStatement p=conn.prepareStatement(sql);

		p.setInt(1, i.getIncomeid());
		p.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public float SumIncome(int userid){
		Statement stmt=null;
		ResultSet rs=null;
		Income Income=null;
		float sum=0;
		Connection conn=util.JdbcUtil.getConnection();
		String sql="select sum(money) from income where userid=?";
		try {
			stmt=conn.createStatement();
			PreparedStatement p=conn.prepareStatement(sql);
			p.setInt(1, userid);
			rs=p.executeQuery();
			while(rs.next()){
				sum=rs.getFloat(1);
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
		return sum;
	}

}
