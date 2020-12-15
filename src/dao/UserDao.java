package dao;

import java.util.ArrayList;
import java.util.List;

import dbutil.SQLHelper;
import entity.User;

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
}
