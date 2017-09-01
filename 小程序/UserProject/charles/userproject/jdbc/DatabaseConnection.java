package charles.userproject.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/java_web?useSSL=true&serverTimezone=UTC&amp&characterEncoding=utf-8";
	private static final String USERNAME="root";
	private static final String PASSWORD="898218";
	private Connection conn=null;
	//初始化数据库连接对象
	public DatabaseConnection() throws Exception{
		Class.forName(DRIVER);
		this.conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}
	//获得数据库连接
	public Connection getConnection(){
		return this.conn;
	}
	//关闭数据库连接
	public void closed() throws Exception{
		try{
			this.conn.close();
		}catch(Exception e){
			throw e;
		}
	}
}
