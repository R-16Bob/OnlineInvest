package entity;

import java.sql.Timestamp;;

public class Invest {
	private int id;
	private String title;
	private String content;
	private int state;
	private int user_id;
	private String created;
	public Invest() {
	} 
	public Invest(int id, String title, String content, int state, int user_id, String created) {
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
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	@Override
	public String toString() {
		return "id=" + id + ", title=" + title + ", content=" + content + ", state=" + state + ", user_id="
				+ user_id + ", created=" + created + "]";
	}  
	
}
