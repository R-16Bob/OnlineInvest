package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Answer;
import entity.Choice;
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
	//根据q_id查询选项
	public List<Choice> queryChoicesByQ_id(int q_id){
		List<Choice> cList=new ArrayList<Choice>();
		String sql="select * from choice where question_id=?";
		List<Object[]> arrs=SQLHelper.executeQueryByParamsAsList(sql, q_id);
		for(Object[] arr:arrs) {
			Choice choice=new Choice();
			choice.setC_id(Integer.valueOf(arr[0].toString()));
			choice.setC_content(arr[1].toString());
			choice.setQ_id(Integer.valueOf(arr[2].toString()));
			cList.add(choice);
		}
		return cList;
	}
	//获得choiceList
	public String[] getChoiceContentListByQ_id(int q_id) {
		List<Choice> clist=queryChoicesByQ_id(q_id);
		String[] contents=new String[clist.size()];
		int i=0;
		for(Choice c:clist) {
			contents[i]=c.getC_content();
			i++;
		}
		return contents;
	}
}
