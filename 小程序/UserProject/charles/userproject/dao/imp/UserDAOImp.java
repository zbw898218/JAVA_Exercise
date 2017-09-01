package charles.userproject.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import charles.userproject.dao.IUserDAO;
import charles.userproject.vo.User;

public class UserDAOImp implements IUserDAO {
	private Connection conn=null;
	public UserDAOImp(Connection conn){
		this.conn=conn;
	}
	@Override
	public boolean doCreate(User user) throws Exception {
		boolean flg=false;
		String sql="insert into user(name,sex,birthday) values(?,?,?)";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, user.getName());
		pst.setString(2, user.getSex());
		pst.setDate(3, new java.sql.Date(user.getBirthday().getTime()));
		if(pst.executeUpdate()>0){
			flg=true;
		}
		if(pst!=null){
			pst.close();
		}
		return flg;
	}

	@Override
	public boolean doDelete(int id) throws Exception {
		boolean flg=false;
		String sql="delete from user where id=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setInt(1, id);
		if(pst.executeUpdate()>0){
			flg=true;
		}		
		if(pst!=null){
			pst.close();
		}
		return flg;
	}

	@Override
	public User findByid(int id) throws Exception {
		String sql="select name,sex,birthday from user where id=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setInt(1, id);
		User user=new User();
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			user.setId(id);
			user.setName(rs.getString(1));
			user.setSex(rs.getString(2));
			user.setBirthday(rs.getDate(3));
		}
		if(rs!=null){
			rs.close();
		}
		if(pst!=null){
			pst.close();
		}
		return user;
	
	}

	@Override
	public List<User> findAll(String keyword) throws Exception {
		String sql="select id,name,sex,birthday from user where name like ? or sex like ? or birthday like ?";
		PreparedStatement pst=conn.prepareStatement(sql);
		List<User> userList=new ArrayList<>();
		pst.setString(1, "%"+keyword+"%");
		pst.setString(2, "%"+keyword+"%");
		pst.setString(3, "%"+keyword+"%");
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			User user=new User();
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setSex(rs.getString(3));
			user.setBirthday(rs.getDate(4));
			userList.add(user);
		}
		if(rs!=null){
			rs.close();
		}
		if(pst!=null){
			pst.close();
		}
		return userList;
	}

	@Override
	public boolean doUpdate(User user) throws Exception {
		boolean flg=false;
		String sql="update user set name=?,sex=?,birthday=? where id=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, user.getName());
		pst.setString(2, user.getSex());
		pst.setDate(3, new java.sql.Date(user.getBirthday().getTime()));
		pst.setInt(4, user.getId());
		if(pst.executeUpdate()>0){
			flg=true;
		}
		if(pst!=null){
			pst.close();
		}
		return flg;
	}

}
