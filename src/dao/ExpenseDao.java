package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Expense;
import entity.Income;

public class ExpenseDao {
	public void addExpense(Expense x){
	Connection conn=util.JdbcUtil.getConnection();
	try {
		String sql="insert into expense(time,item,money,userid)values(?,?,?,?)";
		PreparedStatement p=conn.prepareStatement(sql);
		p.setString(1, x.getTime());
		p.setString(2, x.getItem());
		p.setFloat(3, x.getMoney());
		p.setInt(4, x.getUserid());
		p.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public  List<Expense> selectByExpenseid(int expenseid){
		Statement stmt=null;
		ResultSet rs=null;
		Expense Income=null;
		List<Expense> ExpenseI=new ArrayList<Expense>();
		Connection conn=util.JdbcUtil.getConnection();
		String sql="select * from expense where expenseid=?";
		try {
			stmt=conn.createStatement();
			PreparedStatement p=conn.prepareStatement(sql);
			p.setInt(1, expenseid);
			rs=p.executeQuery();
			while(rs.next()){
				 Income=new Expense();
				 Income.setExpenseid(rs.getInt(1));
				 Income.setTime(rs.getString(2));
				 Income.setItem(rs.getString(3));
				 Income.setMoney(rs.getFloat(4));
				 Income.setUserid(rs.getInt(5));
				 ExpenseI.add(Income);
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
		return ExpenseI;
	}
	public  List<Expense> findById(int userid){
		Statement stmt=null;
		ResultSet rs=null;
		Expense Income=null;
		List<Expense> ExpenseI=new ArrayList<Expense>();
		Connection conn=util.JdbcUtil.getConnection();
		String sql="select * from expense where userid=?";
		try {
			stmt=conn.createStatement();
			PreparedStatement p=conn.prepareStatement(sql);
			p.setInt(1, userid);
			rs=p.executeQuery();
			while(rs.next()){
				 Income=new Expense();
				 Income.setExpenseid(rs.getInt(1));
				 Income.setTime(rs.getString(2));
				 Income.setItem(rs.getString(3));
				 Income.setMoney(rs.getFloat(4));
				 Income.setUserid(rs.getInt(5));
				 ExpenseI.add(Income);
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
		return ExpenseI;
	}

	public void UpdateExpense(Expense i){
	Connection conn=util.JdbcUtil.getConnection();
	try {
		String sql="update expense set time=?,item=?,money=? where expenseid=?";
		PreparedStatement p=conn.prepareStatement(sql);
		
		p.setString(1, i.getTime());
		p.setString(2, i.getItem());
		p.setFloat(3, i.getMoney());
		p.setInt(4, i.getExpenseid());
		p.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	public void DeleteExpense(Expense x){
	Connection conn=util.JdbcUtil.getConnection();
	try {
		String sql="delete from expense where expenseid=?";
		PreparedStatement p=conn.prepareStatement(sql);

		p.setInt(1, x.getExpenseid());
		p.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public float SumExpense(int userid){
		Statement stmt=null;
		ResultSet rs=null;
		float sum = 0;
		Connection conn=util.JdbcUtil.getConnection();
		String sql="select sum(money) from expense where userid=?";
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
