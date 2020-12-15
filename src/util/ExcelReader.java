package util;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import dao.ChoiceDao;
import dao.InvestDao;
import dao.QuestionDao;
public class ExcelReader {
	public boolean read(String fileName,int user_id) throws EncryptedDocumentException, IOException{
		if(fileName==null) return false;
		InvestDao investDao=new InvestDao();
		ChoiceDao choiceDao=new ChoiceDao();
		QuestionDao questionDao=new QuestionDao();
		File xlsFile = new File(fileName);
		if(!xlsFile.exists()) return false;	
		//工作表
		Workbook workbook=WorkbookFactory.create(xlsFile);
		//表个数
		int numberOfSheets = workbook.getNumberOfSheets();
		//System.out.println(numberOfSheets);
		if(numberOfSheets<=0) return false;
		//只处理一个表，不需要遍历
		Sheet sheet=workbook.getSheetAt(0);
		//行数
		int rowNumbers=sheet.getLastRowNum()+1;
		//读数据，先读第一行的标题和描述
		Row r1=sheet.getRow(0);
		String title=r1.getCell(0).toString();
		String content=r1.getCell(1).toString();
		//插入invest
		investDao.addInvest(title, content, user_id);
		//从第二行开始读取问题
		for(int row=1;row<rowNumbers;row++) {
			Row r=sheet.getRow(row);
			int colNum=r.getPhysicalNumberOfCells();  //不为空的列数
			String q_content=r.getCell(0).toString();
			if(!r.getCell(1).toString().matches("^\\d+(\\.\\d+)?"))
				return false;
			int type=Double.valueOf(r.getCell(1).toString()).intValue();
			//插入question
			questionDao.addQuestion(r.getCell(0).toString(), investDao.getLastInvest_id(), type);
			if(type==1||type==2) {  //单选或多选，还要把后面列的选项加插入数据库
				for(int i=2;i<colNum;i++) {
					choiceDao.addChoice(r.getCell(i).toString(), questionDao.getLastQuestion_id());
				}
			}else {
				//其他type默认为填空题
			}
		}
		return true;
	}
}
