package charles.userproject.test;

import java.util.Date;

import charles.userproject.dao.IUserDAO;
import charles.userproject.factory.UserDAOFactory;
import charles.userproject.vo.User;

public class testinsert {

	public static void main(String[] args) {
		User user=new User();
		user.setName("张三");
		user.setSex("男");
		user.setBirthday(new Date());
		IUserDAO userdao=UserDAOFactory.getUserDAOInstance();
		try {
			userdao.doCreate(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
