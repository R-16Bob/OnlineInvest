package util;

import java.io.File;
import java.util.List;
import javax.print.PrintException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.examples.CreateCell;

import entity.Question;
import entity.StatisticView;



public class ExcelWriter {
	public void write(String fileName,List<Question> qlist,List<StatisticView> slist) {
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet sheet=workbook.createSheet("StudentScore");
		
		//创建Excel标题行，即第一行
		HSSFRow headRow=sheet.createRow(0);
		headRow.createCell(0).setCellValue("提交时间");
		headRow.createCell(1).setCellValue("来自IP");
		int cnum=2;  //cell的下标
		int snum=0;  //slist的下标
		for(Question q:qlist) {
			headRow.createCell(cnum).setCellValue(q.getQ_content());
			cnum++;
		}
		//往Excel表中写入每一行数据
		for(int i=0;i<slist.size();) {
			HSSFRow dataRow=sheet.createRow(sheet.getLastRowNum()+1);
			dataRow.createCell(0).setCellValue(slist.get(i).getCreated());
			dataRow.createCell(1).setCellValue(slist.get(i).getIp());
			cnum=2;
			for(int j=2;j<qlist.size()+2;j++) {
				dataRow.createCell(cnum).setCellValue(slist.get(i).getA_content());
				i++;
				cnum++;
			}
		}
		File xlsFile=new File(fileName);
		try {
			//或者以流的形式写入文件 workbook.write(new FileOutputStream(xlsFile));
			workbook.write(xlsFile);
		} catch (Exception e) {			
			// TODO
		} finally {
			try {
				workbook.close();
			} catch (Exception e2) {
				// TODO
			}
		}
	}

}

