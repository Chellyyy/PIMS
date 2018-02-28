/**
 * 
 */
/**
 * @author hcy
 *
 */
package entity;
public class User {
	private int userid;
	private String username;
	private String password;
	private String name;
	private String sex;
	private String year;
	private String month;
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String mounth) {
		this.month = mounth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User(int userid,String username,String password){
		this.userid=userid;
		this.username=username;
		this.password=password;
	}
	public User(){
		super();
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}