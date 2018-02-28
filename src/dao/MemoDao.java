package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Memo;

public class MemoDao {
	public void addMemo(Memo m){
	Connection conn=util.JdbcUtil.getConnection();
	try {
		String sql="insert into memo(time,memo,place,userid)values(date_format(current_timestamp,'%y-%m-%d'),?,?,?)";
		PreparedStatement p=conn.prepareStatement(sql);
		p.setString(1, m.getMemo());
		p.setString(2, m.getPlace());
		p.setInt(3, m.getUserid());
		p.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public  List<Memo> selectByTime(String time,int userid){
		Statement stmt=null;
		ResultSet rs=null;
		Memo Memo=null;
		List<Memo> MemoI=new ArrayList<Memo>();
		Connection conn=util.JdbcUtil.getConnection();
		String sql="select * from memo where time=? and userid=?";
		try {
			stmt=conn.createStatement();
			PreparedStatement p=conn.prepareStatement(sql);
			p.setString(1, time);
			p.setInt(2, userid);
			rs=p.executeQuery();
			while(rs.next()){
				 Memo=new Memo();
				 Memo.setMemoid(rs.getInt(1));
				 Memo.setTime(rs.getString(2));
				 Memo.setMemo(rs.getString(3));
				 Memo.setPlace(rs.getString(4));
				 Memo.setUserid(rs.getInt(5));
				 MemoI.add(Memo);
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
		return MemoI;
	}
	public  List<Memo> selectByMemoid(int memoid){
		Statement stmt=null;
		ResultSet rs=null;
		Memo Memo=null;
		List<Memo> MemoI=new ArrayList<Memo>();
		Connection conn=util.JdbcUtil.getConnection();
		String sql="select * from memo where memoid=?";
		try {
			stmt=conn.createStatement();
			PreparedStatement p=conn.prepareStatement(sql);
			p.setInt(1, memoid);
			rs=p.executeQuery();
			while(rs.next()){
				 Memo=new Memo();
				 Memo.setMemoid(rs.getInt(1));
				 Memo.setTime(rs.getString(2));
				 Memo.setMemo(rs.getString(3));
				 Memo.setPlace(rs.getString(4));
				 Memo.setUserid(rs.getInt(5));
				 MemoI.add(Memo);
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
		return MemoI;
	}
	public  List<Memo> findById(int userid){
		Statement stmt=null;
		ResultSet rs=null;
		Memo Memo=null;
		List<Memo> MemoI=new ArrayList<Memo>();
		Connection conn=util.JdbcUtil.getConnection();
		String sql="select * from memo where userid=?";
		try {
			stmt=conn.createStatement();
			PreparedStatement p=conn.prepareStatement(sql);
			p.setInt(1, userid);
			rs=p.executeQuery();
			while(rs.next()){
				 Memo=new Memo();
				 Memo.setMemoid(rs.getInt(1));
				 Memo.setTime(rs.getString(2));
				 Memo.setMemo(rs.getString(3));
				 Memo.setPlace(rs.getString(4));
				 Memo.setUserid(rs.getInt(5));
				 MemoI.add(Memo);
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
		return MemoI;
	}

	public void UpdateMemo(Memo m){
	Connection conn=util.JdbcUtil.getConnection();
	try {
		String sql="update memo set time=date_format(current_timestamp,'%y-%m-%d'),memo=?,place=? where memoid=?";
		PreparedStatement p=conn.prepareStatement(sql);
		
		p.setString(1, m.getMemo());
		p.setString(2, m.getPlace());
		p.setInt(3, m.getMemoid());
		p.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	public void DeleteMemo(Memo m){
	Connection conn=util.JdbcUtil.getConnection();
	try {
		String sql="delete from memo where memoid=?";
		PreparedStatement p=conn.prepareStatement(sql);

		p.setInt(1, m.getMemoid());
		p.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
