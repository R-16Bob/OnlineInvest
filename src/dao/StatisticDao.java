package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hslf.util.SystemTimeUtils;

import entity.Answer;
import entity.Choice;
import entity.Question;
import entity.Statistic;
import entity.StatisticView;
import util.SQLHelper;

public class StatisticDao {
	//向数据库插入统计信息
	public int addStatistic(int answer_id,String ip){
		String sql="insert into statistic(answer_id,ip) values(?,?)";
		return SQLHelper.executeUpdateByParams(sql, answer_id,ip);
	}
	
	//输入问卷id,返回统计列表
	public List<Statistic> getResult(int i_id){
		QuestionDao qdao=new QuestionDao();
		AnswerDao adao=new AnswerDao();
		ChoiceDao cdao=new ChoiceDao();
		//获取问题列表
		List<Question> qList=qdao.queryQuestionByI_id(i_id);
		List<Statistic> sList=new ArrayList<Statistic>();
		for(Question q:qList) {
			//获取问题对应的回答列表
			List<Answer> alist=adao.queryAnswersByQ_id(q.getQ_id());
			//如果为单选或多选,获取选项
			if(q.getType()==1||q.getType()==2) {
				String[] contents= cdao.getChoiceContentListByQ_id(q.getQ_id());
				//获得各选项人数
				int[] amount=new int[contents.length];
				if(q.getType()==1) {  //单选题
					for(Answer a:alist) {
						for(int i=0;i<contents.length;i++) {
							if(a.getA_content().equals(contents[i])) {
								amount[i]+=1;
							}
						}
					}
				}
				if(q.getType()==2) {  //多选题
					for(Answer a:alist) {
						String[] atext=a.getA_content().split("\\|");
						for(int i=0;i<atext.length;i++) {
							for(int j=0;j<contents.length;j++) {
								System.out.println(atext[i]+"比较"+contents[j]);
								if(atext[i].equals(contents[j])) {
									amount[j]+=1;
								}
							}
						}
					}
				}
				//使用带参数构造方法生成统计列表
				Statistic sta=new Statistic(q.getQ_id(),q.getQ_content(), q.getType(), alist.size(), contents, amount,contents.length);
				//对单选和多选计算百分比
				sta.calculatePercent();
				//加入列表
				sList.add(sta);
			}else {  //为填空题，只需要保存contents
				String[] contents=new String[alist.size()];
				int i=0;
				for(Answer a:alist) {
					contents[i]=a.getA_content();
					i++;
				}
				Statistic sta=new Statistic(q.getQ_id(), q.getQ_content(),q.getType(), alist.size(), contents, null,0);
				sList.add(sta);
			}
		}
		return sList;
	}
	
	//根据inv_id获取statisticView列表
	public List<StatisticView> getStatisticViewsByI_id(int i_id){
		List<StatisticView> slist=new ArrayList<StatisticView>();
		String sql="select * from statisticView where invest_id=?";
		List<Object[]> arrs=SQLHelper.executeQueryByParamsAsList(sql, i_id);
		for(Object[] arr:arrs) {
			StatisticView sv=new StatisticView();
			sv.setAnswer_id(Integer.valueOf(arr[0].toString()));
			sv.setQuestion_id(Integer.valueOf(arr[4].toString()));
			sv.setInvest_id(Integer.valueOf(arr[6].toString()));
			sv.setIp(arr[1].toString());
			sv.setCreated(arr[2].toString());
			sv.setA_content(arr[3].toString());
			sv.setQ_content(arr[5].toString());
			slist.add(sv);
		}
		return slist;
	}
}
