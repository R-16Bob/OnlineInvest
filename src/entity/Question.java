package entity;

public class Question {
	private int q_id;
	private String q_content;
	private int i_id;
	private int type;
	public Question() {
	}
	public Question(int q_id, String q_content, int i_id, int type) {
		this.q_id = q_id;
		this.q_content = q_content;
		this.i_id = i_id;
		this.type = type;
	}
	public int getQ_id() {
		return q_id;
	}
	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}
	public String getQ_content() {
		return q_content;
	}
	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	public int getI_id() {
		return i_id;
	}
	public void setI_id(int i_id) {
		this.i_id = i_id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "q_id=" + q_id + ", q_content=" + q_content + ", i_id=" + i_id + ", type=" + type + "]";
	}
	
}
