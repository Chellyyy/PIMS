package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Diary;

public class DiaryDao {
	public void addDiary(Diary d){
	Connection conn=util.JdbcUtil.getConnection();
	try {
		String sql="insert into diary(time,place,detail,people,userid)values(date_format(current_timestamp,'%y-%m-%d'),?,?,?,?)";
		PreparedStatement p=conn.prepareStatement(sql);
		p.setString(1, d.getPlace());
		p.setString(2, d.getDetail());
		p.setString(3, d.getPeople());
		p.setInt(4, d.getUserid());
		p.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public  List<Diary> selectByDiaryid(int diaryid){
		Statement stmt=null;
		ResultSet rs=null;
		Diary Diary=null;
		List<Diary> DiaryI=new ArrayList<Diary>();
		Connection conn=util.JdbcUtil.getConnection();
		String sql="select * from diary where diaryid=?";
		try {
			stmt=conn.createStatement();
			PreparedStatement p=conn.prepareStatement(sql);
			p.setInt(1, diaryid);
			rs=p.executeQuery();
			while(rs.next()){
				 Diary=new Diary();
				 Diary.setDiaryid(rs.getInt(1));
				 Diary.setTime(rs.getString(2));
				 Diary.setPlace(rs.getString(3));
				 Diary.setDetail(rs.getString(4));
				 Diary.setPeople(rs.getString(5));
				 Diary.setUserid(rs.getInt(6));
				 DiaryI.add(Diary);
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
		return DiaryI;
	}
	public  List<Diary> selectByTime(String time,int userid){
		Statement stmt=null;
		ResultSet rs=null;
		Diary Diary=null;
		List<Diary> DiaryI=new ArrayList<Diary>();
		Connection conn=util.JdbcUtil.getConnection();
		String sql="select * from diary where time=? and userid=?";
		try {
			stmt=conn.createStatement();
			PreparedStatement p=conn.prepareStatement(sql);
			p.setString(1, time);
			p.setInt(2, userid);
			rs=p.executeQuery();
			while(rs.next()){
				 Diary=new Diary();
				 Diary.setDiaryid(rs.getInt(1));
				 Diary.setTime(rs.getString(2));
				 Diary.setPlace(rs.getString(3));
				 Diary.setDetail(rs.getString(4));
				 Diary.setPeople(rs.getString(5));
				 Diary.setUserid(rs.getInt(6));
				 DiaryI.add(Diary);
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
		return DiaryI;
	}

	public  List<Diary> findById(int userid){
		Statement stmt=null;
		ResultSet rs=null;
		Diary Diary=null;
		List<Diary> DiaryI=new ArrayList<Diary>();
		Connection conn=util.JdbcUtil.getConnection();
		String sql="select * from diary where userid=?";
		try {
			stmt=conn.createStatement();
			PreparedStatement p=conn.prepareStatement(sql);
			p.setInt(1, userid);
			rs=p.executeQuery();
			while(rs.next()){
				 Diary=new Diary();
				 Diary.setDiaryid(rs.getInt(1));
				 Diary.setTime(rs.getString(2));
				 Diary.setPlace(rs.getString(3));
				 Diary.setDetail(rs.getString(4));
				 Diary.setPeople(rs.getString(5));
				 Diary.setUserid(rs.getInt(6));
				 DiaryI.add(Diary);
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
		return DiaryI;
	}

	public void UpdateDiary(Diary d){
	Connection conn=util.JdbcUtil.getConnection();
	try {
		String sql="update diary set time=date_format(current_timestamp,'%y-%m-%d'),place=?,detail=?,people=? where diaryid=?";
		PreparedStatement p=conn.prepareStatement(sql);
		
		p.setString(1, d.getPlace());
		p.setString(2, d.getDetail());
		p.setString(3, d.getPeople());
		p.setInt(4, d.getDiaryid());
		p.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	public void DeleteDiary(Diary d){
	Connection conn=util.JdbcUtil.getConnection();
	try {
		String sql="delete from diary where diaryid=?";
		PreparedStatement p=conn.prepareStatement(sql);

		p.setInt(1, d.getDiaryid());
		p.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
