package charles.userproject.dao;

import java.util.List;

import charles.userproject.vo.User;

public interface IUserDAO {
	boolean doCreate(User user) throws Exception;
	boolean doDelete(int id) throws Exception;
	User findByid(int id) throws Exception;
	List<User> findAll(String keyword) throws Exception;
	boolean doUpdate(User user) throws Exception;
}
