package charles.news_manage.dao.proxy;

import charles.news_manage.dao.IUserDAO;
import charles.news_manage.dao.Imp.UserDAOImp;
import charles.news_manage.entity.User;
import charles.news_manage.util.DatabaseConnection;

import java.sql.Connection;

/**
 * Created by Charles Zheng on 2017/8/2.
 */
public class UserProxy implements IUserDAO{
    private IUserDAO userDAO=null;
    private Connection conn=null;
    public UserProxy() throws Exception{

    }

    @Override
    public boolean findByUser(User user) throws Exception {
        boolean login=false;
        try {
            this.conn=new DatabaseConnection().getConnection();
        } catch (Exception e) {
            throw e;
        }
        this.userDAO=new UserDAOImp(this.conn);
        try {
            login =this.userDAO.findByUser(user);
        }catch(Exception e){
            throw e;
        }finally {
            if(this.conn!=null){
                this.conn.close();
            }
        }
        return login;
    }

    @Override
    public boolean doInsert(User user) throws Exception {
        boolean reg=false;
        try {
            this.conn=new DatabaseConnection().getConnection();
        } catch (Exception e) {
            throw e;
        }
        this.userDAO=new UserDAOImp(this.conn);
        try {
            reg =this.userDAO.doInsert(user);
        }catch(Exception e){
            throw e;
        }finally {
            if(this.conn!=null){
                this.conn.close();
            }
        }
        return reg;

    }

    @Override
    public boolean doUpdate(User user) throws Exception {
        boolean isUpdate=false;
        try {
            this.conn=new DatabaseConnection().getConnection();
        } catch (Exception e) {
            throw e;
        }
        this.userDAO=new UserDAOImp(this.conn);
        try {
            isUpdate =this.userDAO.doUpdate(user);
        }catch(Exception e){
            throw e;
        }finally {
            if(this.conn!=null){
                this.conn.close();
            }
        }
        return isUpdate;
    }
}
