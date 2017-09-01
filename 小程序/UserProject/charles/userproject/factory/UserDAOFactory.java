package charles.userproject.factory;

import charles.userproject.dao.IUserDAO;
import charles.userproject.proxy.UserDAOProxy;

public class UserDAOFactory {
	public static IUserDAO getUserDAOInstance(){
		return new UserDAOProxy();
	}
}
