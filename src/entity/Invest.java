package entity;

import java.sql.Timestamp;;

public class Invest {
	private int id;
	private String title;
	private String content;
	private int status;
	private int user_id;
	private String created;
	public Invest() {
	} 
	public Invest(int id, String title, String content, int status, int user_id, String created) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.status = status;
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
	public int getStatus() {
		return status;
	}
	public void setState(int status) {
		this.status = status;
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
		return "id=" + id + ", title=" + title + ", content=" + content + ", status=" + status + ", user_id="
				+ user_id + ", created=" + created + "]";
	}  
	
}
