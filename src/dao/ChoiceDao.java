package dao;

import util.SQLHelper;

public class ChoiceDao {
	public int addChoice(String content,int question_id){
		String sql="insert into choice(content,question_id) values(?,?)";
		return SQLHelper.executeUpdateByParams(sql, content,question_id);
	}
}
