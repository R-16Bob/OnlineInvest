package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Answer;
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
	//根据q_id查询回答
	public List<Answer> queryAnswersByQ_id(int q_id){
		List<Answer> aList=new ArrayList<Answer>();
		String sql="select * from answer where question_id=?";
		List<Object[]> arrs=SQLHelper.executeQueryByParamsAsList(sql, q_id);
		for(Object[] arr:arrs) {
			Answer answer=new Answer();
			answer.setA_id(Integer.valueOf(arr[0].toString()));
			answer.setA_content(arr[1].toString());
			answer.setQ_id(Integer.valueOf(arr[2].toString()));
			aList.add(answer);
		}
		return aList;
	}
}
