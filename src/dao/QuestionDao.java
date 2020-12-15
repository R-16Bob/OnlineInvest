package dao;

import java.util.List;

import util.SQLHelper;

public class QuestionDao {
	public int addQuestion(String content,int invest_id ,int type){
		String sql="insert into question(content,invest_id,type) values(?,?,?)";
		return SQLHelper.executeUpdateByParams(sql, content,invest_id,type);
	}
	public int getLastQuestion_id(){
		String sql="select * from question";
		List<Object[]> list=SQLHelper.executeQueryAsList(sql);
		if(list.size()==0)
			return 0;
		Object[] last=list.get(list.size()-1);
		return Integer.valueOf(last[0].toString());
	}
}
