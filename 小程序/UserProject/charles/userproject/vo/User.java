package charles.userproject.vo;

import java.util.Date;

public class User {
	private int id;
	private String name;
	private String sex;
	private Date birthday;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "用户信息 [编号=" + id + ", 姓名=" + name + ", 性别=" + sex + ", 生日=" + birthday + "]";
	}
	
}
