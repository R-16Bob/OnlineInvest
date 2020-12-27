package entity;
//  该类存储每个答案的统计结果，与数据库中statistic不同

import java.text.NumberFormat;
import java.util.Arrays;

public class Statistic {
	private int question_id;
	private String q_content;  //问题描述
	private int type;  //问题类型
	private int sum;  //答卷总数
	String[] contents;  //选项名，填空题为答案名
	int[] amount;  //每个选项人数，填空题为空
	String[] percent;  //对单选题和多选题计算百分比
	int cnum;  //选项数
	public Statistic() {
	}
	
	public Statistic(int question_id, String q_content, int type, int sum, String[] contents, int[] amount, int cnum) {
		this.question_id = question_id;
		this.q_content = q_content;
		this.type = type;
		this.sum = sum;
		this.contents = contents;
		this.amount = amount;
		this.cnum = cnum;
	}

	public void calculatePercent() {
		percent=new String[contents.length];
		for(int i=0;i<percent.length;i++) {
			// 创建一个数值格式化对象   
			NumberFormat numberFormat = NumberFormat.getInstance();   
			// 设置精确到小数点后2位   
			numberFormat.setMaximumFractionDigits(2);   
			String result = numberFormat.format((float)amount[i]/(float)sum*100);
			percent[i]=result;
			//System.out.println("百分比为:" + result + "%");  		
		}

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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public String[] getContents() {
		return contents;
	}

	public void setContents(String[] contents) {
		this.contents = contents;
	}

	public int[] getAmount() {
		return amount;
	}

	public void setAmount(int[] amount) {
		this.amount = amount;
	}

	public String[] getPercent() {
		return percent;
	}

	public void setPercent(String[] percent) {
		this.percent = percent;
	}

	public int getCnum() {
		return cnum;
	}

	public void setCnum(int cnum) {
		this.cnum = cnum;
	}

	@Override
	public String toString() {
		return "Statistic [question_id=" + question_id + ", type=" + type + ", sum=" + sum + ", contents="
				+ Arrays.toString(contents) + ", amount=" + Arrays.toString(amount) + ", percent="
				+ Arrays.toString(percent) + "]";
	}
	
}
