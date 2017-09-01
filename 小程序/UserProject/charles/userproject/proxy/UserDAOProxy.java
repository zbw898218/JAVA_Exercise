package charles.userproject.proxy;

import java.util.List;

import charles.userproject.dao.IUserDAO;
import charles.userproject.dao.imp.UserDAOImp;
import charles.userproject.jdbc.DatabaseConnection;
import charles.userproject.vo.User;

public class UserDAOProxy implements IUserDAO {
	private DatabaseConnection dbc=null;
	private IUserDAO userDao=null;
	public UserDAOProxy(){
		try {
			this.dbc=new DatabaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		userDao=new UserDAOImp(this.dbc.getConnection());	
	}

	@Override
	public boolean doCreate(User user) throws Exception {
		boolean flg=false;
		try{
			flg=this.userDao.doCreate(user);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.closed();
		}		
		return flg;
	}

	@Override
	public boolean doDelete(int id) throws Exception {
		boolean flg=false;
		try{
			flg=this.userDao.doDelete(id);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.closed();
		}		
		return flg;
	}

	@Override
	public User findByid(int id) throws Exception {
		User user=null;
		try{
			user=this.userDao.findByid(id);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.closed();
		}	
		return user;
	}

	@Override
	public List<User> findAll(String keyword) throws Exception {
		List<User> userList=null;
		try{
			userList=this.userDao.findAll(keyword);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.closed();
		}	
		return userList;
	}

	@Override
	public boolean doUpdate(User user) throws Exception {
		boolean flg=false;
		try{
			flg=this.userDao.doUpdate(user);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.closed();
		}		
		return flg;
	}

}
