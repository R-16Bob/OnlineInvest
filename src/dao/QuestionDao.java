package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Question;
import util.SQLHelper;

public class QuestionDao {
	public int addQuestion(String content,int invest_id ,int type){
		String sql="insert into question(content,invest_id,type) values(?,?,?)";
		return SQLHelper.executeUpdateByParams(sql, content,invest_id,type);
	}
	public int deleteQueByQ_id(int q_id) {
		String sql="delete from question where id=?";
		return SQLHelper.executeUpdateByParams(sql, q_id);
	}
	public int updateQ_content(String q_content,int q_id) {
		String sql="update question set content=? where id=?";
		return SQLHelper.executeUpdateByParams(sql, q_content,q_id);
	}
	public int getLastQuestion_id(){
		String sql="select * from question";
		List<Object[]> list=SQLHelper.executeQueryAsList(sql);
		if(list.size()==0)
			return 0;
		Object[] last=list.get(list.size()-1);
		return Integer.valueOf(last[0].toString());
	}
	public Question getQuestionByQ_id(int q_id) {
		String sql="select * from question where id=?";
		List<Object[]> list=SQLHelper.executeQueryByParamsAsList(sql, q_id);
		Question que=new Question();
		que.setQ_id(q_id);
		que.setQ_content(list.get(0)[1].toString());
		que.setI_id(Integer.valueOf(list.get(0)[2].toString()));
		que.setI_id(Integer.valueOf(list.get(0)[3].toString()));
		return que;
	}
	public List<Question> queryQuestionByI_id(int i_id){
		List<Question> list=new ArrayList<Question>();
		String sql="select * from question where invest_id=?";
		List<Object[]> arrs=SQLHelper.executeQueryByParamsAsList(sql, i_id);
		for(Object[] arr:arrs) {
			Question q=new Question();
			q.setQ_id(Integer.valueOf(arr[0].toString()));
			q.setQ_content(arr[1].toString());
			q.setI_id(i_id);
			q.setType(Integer.valueOf(arr[3].toString()));
			list.add(q);
		}
		return list;
	}
}
