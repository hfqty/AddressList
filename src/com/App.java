package com;

//App类
public class App {
	//程序入口
	public static void main(String[] args) throws Exception {
		//创建一个TelNoteRegex实例并初始化
		TelNoteRegex tnr =new TelNoteRegex();
		//创建一个Menu实例并初始化
		Menu menu = new Menu();
		//创建一个Operate实例并初始化
		Operate o = new Operate();
		//while循环
		while(true) {
			//显示主菜单
			menu.mainMenu();
			//判断并接收用户输入
			int key = tnr.menuRegex(1,6);
			//判断选项
			switch (key) {
			//添加联系人
			case 1: o.addLogic();break;
			//查找联系人
			case 2:	o.searchLogic();break;
			//修改联系人
			case 3: o.modifyLogic(); break;
			//删除联系人
			case 4: o.deleteLogic(); break;
			//为联系人排序
			case 5: o.orderLogic();break;
			//退出系统
			case 6: System.exit(0);
			}
		}
	}
}
