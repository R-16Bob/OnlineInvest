package entity;

public class ChoiceView {
	private int q_id;
	private String q_content;
	private int i_id;
	private int type;
	private int c_id;
	private String c_content;
	public ChoiceView() {
	}
	public ChoiceView(int q_id, String q_content, int i_id, int type, int c_id, String c_content) {
		this.q_id = q_id;
		this.q_content = q_content;
		this.i_id = i_id;
		this.type = type;
		this.c_id = c_id;
		this.c_content = c_content;
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
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	@Override
	public String toString() {
		return "q_id=" + q_id + ", q_content=" + q_content + ", i_id=" + i_id + ", type=" + type + ", c_id="
				+ c_id + ", c_content=" + c_content + "]";
	}
	
}
