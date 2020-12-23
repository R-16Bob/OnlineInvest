package dao;

import util.SQLHelper;

public class StatisticDao {
	public int addStatistic(int answer_id,String ip){
		String sql="insert into statistic(answer_id,ip) values(?,?)";
		return SQLHelper.executeUpdateByParams(sql, answer_id,ip);
	}
}
