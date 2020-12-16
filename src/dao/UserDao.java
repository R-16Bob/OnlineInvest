package dao;

import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.SQLHelper;

public class UserDao {
	public List<User> queryAllUsers(){
   	 List<User> ulist=new ArrayList<User>();
   	 String sql="select * from user";
   	 List<Object[]> list=SQLHelper.executeQueryAsList(sql);
   	 for(Object[] arr:list) {
   		 User u=new User();
   		 u.setId(Integer.valueOf(arr[0].toString()));
   		 u.setUser_name(arr[1].toString());
   		 u.setPwd(arr[2].toString());
   		 u.setType(Integer.valueOf(arr[3].toString()));
   		 ulist.add(u);
   	 }
   	 return ulist;
	}
	//添加普通用户
	public int addUser(String user_name,String pwd) {
		String sql="insert into user(user_name,pwd) values(?,?)";
		return SQLHelper.executeUpdateByParams(sql, user_name,pwd);
	}
	//根据用户名查找id
	public int getIdByUname(String user_name) {
		String sql="select id from user where user_name=?";
		List<Object[]> list=SQLHelper.executeQueryByParamsAsList(sql, user_name);
		if(list.size()==0)
			return 0;
		else return Integer.valueOf(list.get(0)[0].toString());
	}
}
