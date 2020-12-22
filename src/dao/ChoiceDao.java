package dao;

import util.SQLHelper;

public class ChoiceDao {
	public int addChoice(String content,int question_id){
		String sql="insert into choice(content,question_id) values(?,?)";
		return SQLHelper.executeUpdateByParams(sql, content,question_id);
	}
	public int updateC_content(String c_content,int c_id) {
		String sql="update choice set content=? where id=?";
		return SQLHelper.executeUpdateByParams(sql, c_content,c_id);
	}
}
