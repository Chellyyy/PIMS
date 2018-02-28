package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Address;

public class AddressDao{
	public void addAddress(Address a){
	Connection conn=util.JdbcUtil.getConnection();
	try {
		String sql="insert into address(addressname,telephone,address,city,other,userid)values(?,?,?,?,?,?)";
		PreparedStatement p=conn.prepareStatement(sql);
		p.setString(1, a.getAddressname());
		p.setString(2, a.getTelephone());
		p.setString(3, a.getAddress());
		p.setString(4, a.getCity());
		p.setString(5, a.getOther());
		p.setInt(6, a.getUserid());
		p.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public  List<Address> selectByAddressid(int addressid){
		Statement stmt=null;
		ResultSet rs=null;
		Address Address=null;
		List<Address> AddressI=new ArrayList<Address>();
		Connection conn=util.JdbcUtil.getConnection();
		String sql="select * from address where addressid=?";
		try {
			stmt=conn.createStatement();
			PreparedStatement p=conn.prepareStatement(sql);
			p.setInt(1, addressid);
			rs=p.executeQuery();
			while(rs.next()){
				 Address=new Address();
				 Address.setAddressid(rs.getInt(1));
				 Address.setAddressname(rs.getString(2));
				 Address.setTelephone(rs.getString(3));
				 Address.setAddress(rs.getString(4));
				 Address.setCity(rs.getString(5));
				 Address.setOther(rs.getString(6));
				 Address.setUserid(rs.getInt(7));
				 AddressI.add(Address);
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
		return AddressI;
	}
	public  List<Address> selectByName(String addressname,int userid){
		Statement stmt=null;
		ResultSet rs=null;
		Address Address=null;
		List<Address> AddressI=new ArrayList<Address>();
		Connection conn=util.JdbcUtil.getConnection();
		String sql="select * from address where addressname=? and userid=?";
		try {
			stmt=conn.createStatement();
			PreparedStatement p=conn.prepareStatement(sql);
			p.setString(1, addressname);
			p.setInt(2, userid);
			rs=p.executeQuery();
			while(rs.next()){
				 Address=new Address();
				 Address.setAddressid(rs.getInt(1));
				 Address.setAddressname(rs.getString(2));
				 Address.setTelephone(rs.getString(3));
				 Address.setAddress(rs.getString(4));
				 Address.setCity(rs.getString(5));
				 Address.setOther(rs.getString(6));
				 Address.setUserid(rs.getInt(7));
				 AddressI.add(Address);
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
		return AddressI;
	}
	public  List<Address> findById(int userid){
		Statement stmt=null;
		ResultSet rs=null;
		Address Address=null;
		List<Address> AddressI=new ArrayList<Address>();
		Connection conn=util.JdbcUtil.getConnection();
		String sql="select * from address where userid=?";
		try {
			stmt=conn.createStatement();
			PreparedStatement p=conn.prepareStatement(sql);
			p.setInt(1, userid);
			rs=p.executeQuery();
			while(rs.next()){
				 Address=new Address();
				 Address.setAddressid(rs.getInt(1));
				 Address.setAddressname(rs.getString(2));
				 Address.setTelephone(rs.getString(3));
				 Address.setAddress(rs.getString(4));
				 Address.setCity(rs.getString(5));
				 Address.setOther(rs.getString(6));
				 Address.setUserid(rs.getInt(7));
				 AddressI.add(Address);
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
		return AddressI;
	}

	public void UpdateAddress(Address a){
	Connection conn=util.JdbcUtil.getConnection();
	try {
		String sql="update address set addressname=?,telephone=?,address=?,city=?,other=? where addressid=?";
		PreparedStatement p=conn.prepareStatement(sql);

		p.setString(1, a.getAddressname());
		p.setString(2, a.getTelephone());
		p.setString(3, a.getAddress());
		p.setString(4, a.getCity());
		p.setString(5, a.getOther());
		p.setInt(6, a.getAddressid());
		p.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	public void DeleteAddress(Address a){
	Connection conn=util.JdbcUtil.getConnection();
	try {
		String sql="delete from address where addressid=?";
		PreparedStatement p=conn.prepareStatement(sql);

		p.setInt(1, a.getAddressid());
		p.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
