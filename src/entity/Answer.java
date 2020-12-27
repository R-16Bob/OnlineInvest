package entity;

public class Answer {
	private int a_id;
	private String a_content;
	private int q_id;
	public Answer() {
	}
	public Answer(int a_id, String a_content, int q_id) {
		this.a_id = a_id;
		this.a_content = a_content;
		this.q_id = q_id;
	}
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getA_content() {
		return a_content;
	}
	public void setA_content(String a_content) {
		this.a_content = a_content;
	}
	public int getQ_id() {
		return q_id;
	}
	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}
	@Override
	public String toString() {
		return "a_id=" + a_id + ", a_content=" + a_content + ", q_id=" + q_id + "]";
	}
	
	
}
