package dao;

import java.util.List;

import util.SQLHelper;

public class AnswerDao {
	public int addAnswer(String content,int question_id){
		String sql="insert into answer(content,question_id) values(?,?)";
		return SQLHelper.executeUpdateByParams(sql, content,question_id);
	}
	//获得answer表末尾的回答id
	public int getLastAnswer_id(){
		String sql="select * from answer";
		List<Object[]> list=SQLHelper.executeQueryAsList(sql);
		if(list.size()==0)
			return 0;
		Object[] last=list.get(list.size()-1);
		return Integer.valueOf(last[0].toString());
	}	
}
