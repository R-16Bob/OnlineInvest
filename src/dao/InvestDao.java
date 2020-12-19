package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Invest;
import util.SQLHelper;

public class InvestDao {
	public int addInvest(String title,String content,int user_id){
		String sql="insert into invest(title,content,user_id) values(?,?,?)";
		return SQLHelper.executeUpdateByParams(sql, title,content,user_id);
	}
	//获得invest表末尾的问卷id
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
	//查询某个用户拥有的所有问卷 
	public List<Invest> queryAllInvestsByUser_id(int id){
    	 List<Invest> list=new ArrayList<Invest>();
    	 String sql="select * from invest where user_id=?";
    	 List<Object[]> invarr=SQLHelper.executeQueryByParamsAsList(sql, id);
    	 for(Object[] arr:invarr) {
    		 Invest inv=new Invest();
    		 inv.setId(Integer.valueOf(arr[0].toString()));
    		 inv.setTitle(arr[1].toString());
    		 inv.setContent(arr[2].toString());
    		 inv.setState(Integer.valueOf(arr[3].toString()));
    		 inv.setUser_id(Integer.valueOf(arr[4].toString()));
    		 inv.setCreated(arr[5].toString().substring(0,16));
    		 list.add(inv);
    	 }
    	 return list;
    }
	//查询特定id的问卷
	public Invest queryInvestByInv_id(int inv_id) {
		String sql="select * from invest where id=?";
   	 List<Object[]> invarr=SQLHelper.executeQueryByParamsAsList(sql, inv_id);
   	 if(invarr.size()==0)
   		 return null;
   	 else {
   		 Invest inv=new Invest();
   		 Object[] arr=invarr.get(0);
   		inv.setId(Integer.valueOf(arr[0].toString()));
		 inv.setTitle(arr[1].toString());
		 inv.setContent(arr[2].toString());
		 inv.setState(Integer.valueOf(arr[3].toString()));
		 inv.setUser_id(Integer.valueOf(arr[4].toString()));
		 inv.setCreated(arr[5].toString().substring(0,16));
		 return inv;
   	 }
	}
	//修改title
	public int updateTitle(int id,String title) {
		String sql="update ";
		return 
	}
}
