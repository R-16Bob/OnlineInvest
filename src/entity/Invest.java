package entity;

import java.sql.Timestamp;;

public class Invest {
	private int id;
	private String title;
	private String content;
	private int state;
	private int user_id;
	private Timestamp created;
	public Invest() {
	} 
	public Invest(int id, String title, String content, int state, int user_id, Timestamp created) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.state = state;
		this.user_id = user_id;
		this.created = created;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}  
	
}
