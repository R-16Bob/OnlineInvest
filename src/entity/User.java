package entity;

public class User {
	private int id;
	private String user_name;
	private String pwd;
	private int type;
	public User() {
	}
	public User(int id, String user_name, String pwd, int type) {
		this.id = id;
		this.user_name = user_name;
		this.pwd = pwd;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", user_name=" + user_name + ", pwd=" + pwd + ", type=" + type + "]";
	}
	
}
