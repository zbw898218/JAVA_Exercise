package charles.userproject.menu;

import charles.userproject.operate.UserOperate;
import charles.userproject.util.InputData;

public class Menu {
	public Menu(){
		while(true){
			this.show();
		}
	}
	public void show(){
		System.out.println("---------人员管理系统-------------");
		System.out.println("\t 1、增加用户");
		System.out.println("\t 2、修改用户");
		System.out.println("\t 3、删除用户");
		System.out.println("\t 4、查询单个用户");
		System.out.println("\t 5、查询全部用户");
		System.out.println("\t 6、退出系统");
		InputData input=new InputData();
		int ch=input.getInt("\n请选择：","请输入正确的选项");
		switch(ch){
		case 1:
			UserOperate.insert();
			break;
		case 2:
			UserOperate.update();
			break;
		case 3:
			UserOperate.delete();
			break;
		case 4:
			UserOperate.findId();
			break;
		case 5:
			UserOperate.findAll();
			break;
		case 6:
			System.exit(1);
			break;
		default:
			System.out.println("请输入正确的选项!");
			break;
		}
	}
}
