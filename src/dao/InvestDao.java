package dao;

import java.util.List;

import util.SQLHelper;

public class InvestDao {
	public int addInvest(String title,String content,int user_id){
		String sql="insert into invest(title,content,user_id) values(?,?,?)";
		return SQLHelper.executeUpdateByParams(sql, title,content,user_id);
	}
	public int getLastInvest_id(){
		String sql="select * from invest";
		List<Object[]> list=SQLHelper.executeQueryAsList(sql);
		if(list.size()==0)
			return 0;
		Object[] last=list.get(list.size()-1);
		return Integer.valueOf(last[0].toString());
	}
	public int deleteInvestById(int invest_id) {
		String sql="delete from invest where id=?";
		return SQLHelper.executeUpdateByParams(sql, invest_id);
	}
}
