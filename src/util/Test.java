package util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;

import dao.AnswerDao;
import dao.ChoiceDao;
import dao.ChoiceViewDao;
import dao.InvestDao;
import dao.QuestionDao;
import entity.Answer;
import entity.ChoiceView;
import entity.Invest;
import entity.Question;
import entity.Statistic;
public class Test {
	//用于测试
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		//Excel读问卷测试
		/*ExcelReader er=new ExcelReader();
		InvestDao investDao =new InvestDao();
		//需要文件名和user_id
		if(!er.read("D:/invest/input/导入问卷.xlsx", 1)) {
			//创建问卷失败，删除问卷
			investDao.deleteInvestById(investDao.getLastInvest_id());
		}*/
		/* 遍历Invest表
		InvestDao investDao=new InvestDao();
		List<Invest> list=investDao.queryAllInvests();
		for(Invest inv:list) {
			System.out.println(inv);
		}*/
		//choiceView
		/* 
		ChoiceViewDao cvdao=new ChoiceViewDao();
		List<ChoiceView> list=cvdao.queryChoiceViewsByinv_id(9);
		for(ChoiceView cv:list) {
			System.out.println(cv);
		}*/
		//Question
		/*QuestionDao qDao=new QuestionDao();
		List<Question> list=qDao.queryQuestionByI_id(9);
		for(Question q:list) {
			System.out.println(q);
		}*/
		/*
		//百分比
		String[] contents= {"是","否"};
		int[] amount= {7,3};
		Statistic sta=new Statistic(1, 1, 10, contents, amount);
		sta.calculatePercent();
		System.out.println(sta.getPercent()[0]+","+sta.getPercent()[1]);
		*/
		//选项
		/*ChoiceDao cdao=new ChoiceDao();
		String[] contents=cdao.getChoiceContentListByQ_id(17);
		System.out.println("选项内容：");
		for(String c:contents) {
			System.out.println(c);
		}*/
		/*//回答
		AnswerDao adao=new AnswerDao();
		List<Answer> aList=adao.queryAnswersByQ_id(17);
		for(Answer a:aList) {
			System.out.println(a);
		}*/
		int[] arr=new int[3];
		System.out.println(arr[0]);
	}

}
