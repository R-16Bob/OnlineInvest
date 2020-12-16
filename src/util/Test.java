package util;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;

import dao.InvestDao;
import entity.Invest;
public class Test {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		//Excel读问卷测试
		ExcelReader er=new ExcelReader();
		InvestDao investDao =new InvestDao();
		//需要文件名和user_id
		if(!er.read("D:/invest/input/导入问卷.xlsx", 1)) {
			//创建问卷失败，删除问卷
			investDao.deleteInvestById(investDao.getLastInvest_id());
		}
		/* 遍历Invest表
		InvestDao investDao=new InvestDao();
		List<Invest> list=investDao.queryAllInvests();
		for(Invest inv:list) {
			System.out.println(inv);
		}*/
	}

}
