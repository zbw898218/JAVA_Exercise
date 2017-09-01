package charles.userproject.operate;

import java.util.Iterator;
import java.util.List;

import charles.userproject.factory.UserDAOFactory;
import charles.userproject.util.InputData;
import charles.userproject.vo.User;

public class UserOperate {
	public static void insert(){
		User user=new User();
		InputData input=new InputData();
		user.setName(input.getString("请输入姓名："));
		user.setSex(input.getString("请输入性别："));
		user.setBirthday(input.getDate("请输入生日：","内容必须是日期（yyyy-mm-dd）"));
		try {
			UserDAOFactory.getUserDAOInstance().doCreate(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void update(){
		InputData input=new InputData();
		int id=input.getInt("请输入要查询的编号", "编号必须是数字");
		User user=null;
		try {
			user=UserDAOFactory.getUserDAOInstance().findByid(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(user!=null){
			user.setName(input.getString("请输入姓名（原姓名："+user.getName()+"）:"));
			user.setSex(input.getString("请输入性别（原性别："+user.getSex()+"）:"));
			user.setBirthday(input.getDate("请输入生日（原生日："+user.getBirthday()+"）:","内容必须是日期（yyyy-mm-dd）"));
			try {
				UserDAOFactory.getUserDAOInstance().doUpdate(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("要查询的用户不存在！");
		}
	}
	public static void delete(){
		InputData input=new InputData();
		int id=input.getInt("请输入要删除的用户编号", "编号必须是数字");
		User user=null;
		try {
			user=UserDAOFactory.getUserDAOInstance().findByid(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(user!=null){
			try {
				UserDAOFactory.getUserDAOInstance().doDelete(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("要删除的用户不存在！");
		}
	}
	public static void findId(){
		InputData input=new InputData();
		int id=input.getInt("请输入要查询的编号", "编号必须是数字");
		User user=null;
		try {
			user=UserDAOFactory.getUserDAOInstance().findByid(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(user!=null){
			System.out.println(user);
		}else{
			System.out.println("要查询的用户不存在！");
		}
	}
	public static void findAll(){
		InputData input=new InputData();
		String keyword=input.getString("请输入要查询的关键字");
		List<User> userlist=null;
		try {
			userlist=UserDAOFactory.getUserDAOInstance().findAll(keyword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Iterator<User> itr=userlist.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
}
