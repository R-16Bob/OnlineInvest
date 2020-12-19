package dao;

import java.util.ArrayList;
import java.util.List;

import entity.ChoiceView;
import util.SQLHelper;

public class ChoiceViewDao {
	public List<ChoiceView> queryChoiceViewsByinv_id(int i_id){
		String sql ="select * from choiceView where invest_id=?";
		List<ChoiceView> list=new ArrayList<ChoiceView>() ;
		List<Object[]> arrs=SQLHelper.executeQueryByParamsAsList(sql, i_id);
		for(Object[] arr:arrs) {
			ChoiceView cv=new ChoiceView();
			cv.setQ_id(Integer.valueOf(arr[0].toString()));
			cv.setQ_content(arr[1].toString());
			cv.setI_id(i_id);
			cv.setType(Integer.valueOf(arr[3].toString()));
			//如果为填空题，后面两个为Null
			if(arr[4]!=null)
				cv.setC_id(Integer.valueOf(arr[4].toString()));
			if(arr[5]!=null)
				cv.setC_content(arr[5].toString());
			list.add(cv);
		}
		return list;
	}
}
