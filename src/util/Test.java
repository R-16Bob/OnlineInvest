package util;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import dao.InvestDao;

public class Test {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		ExcelReader er=new ExcelReader();
		InvestDao investDao =new InvestDao();
		//需要文件名和user_id
		if(!er.read("D:/invest/input/导入问卷.xlsx", 1)) {
			//创建问卷失败，删除问卷
			investDao.deleteInvestById(investDao.getLastInvest_id());
		}
		
	}

}
