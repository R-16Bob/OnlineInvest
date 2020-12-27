package entity;

public class StatisticView {
	private int answer_id;
	private String ip;
	private String created;
	private String a_content;
	private int question_id;
	private String q_content;
	private int invest_id;
	public StatisticView() {
	}
	public StatisticView(int answer_id, String ip, String created, String a_content, int question_id, String q_content,
			int invest_id) {
		this.answer_id = answer_id;
		this.ip = ip;
		this.created = created;
		this.a_content = a_content;
		this.question_id = question_id;
		this.q_content = q_content;
		this.invest_id = invest_id;
	}
	public int getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getA_content() {
		return a_content;
	}
	public void setA_content(String a_content) {
		this.a_content = a_content;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public String getQ_content() {
		return q_content;
	}
	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	public int getInvest_id() {
		return invest_id;
	}
	public void setInvest_id(int invest_id) {
		this.invest_id = invest_id;
	}
	
}
