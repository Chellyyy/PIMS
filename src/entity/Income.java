package entity;

public class Income {
	private int incomeid;
	private String time;
	private String item;
	private float money;
	private int userid;
	
	public int getIncomeid() {
		return incomeid;
	}
	public void setIncomeid(int incomeid) {
		this.incomeid = incomeid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	

}
