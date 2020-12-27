package entity;

import org.apache.poi.xdgf.usermodel.section.geometry.InfiniteLine;

public class Choice {
	private int c_id;
	private String c_content;
	private int q_id;
	public Choice() {
	}
	public Choice(int c_id, String c_content, int q_id) {
		this.c_id = c_id;
		this.c_content = c_content;
		this.q_id = q_id;
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
	public int getQ_id() {
		return q_id;
	}
	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}
	
}
