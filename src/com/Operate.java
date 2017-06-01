package com;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Operate {

	static int state = 0;
	TelNoteRegex tnr = new TelNoteRegex();
	Menu m = new Menu();
	DBHelper db = new DBHelper();
	String sql = "where ";
	Person p = new Person();

	// 添加业务逻辑
	public void addLogic() throws Exception {
		// while循环接收用户输入
		while (true) {
			// 显示添加菜单
			m.addMenu();
			// 验证并接收用户输入
			int key = tnr.menuRegex(1, 3);
			// 判断用户选择
			switch (key) {
			// 添加新纪录
			case 1:
				addOperation();
				break;
			// 显示全部联系人
			case 2:
				showAll();
				break;
			// 返回上一层
			case 3:
				return;
			}// 结束switch
		} // 结束循环
	}// 结束方法

	// 查找业务逻辑
	public void searchLogic() throws Exception {
		System.err.println("支持模糊查找");
		// while循环
		while (true) {
			// 显示搜索菜单
			m.searchMenu();
			// 接受并判断用户输入
			int key = tnr.menuRegex(1, 7);
			// 判断选项
			switch (key) {

			// 通过姓名搜索
			case 1:
				System.out.println("支持模糊查找");
				seachByName();
				break;
			// 通过年龄搜索
			case 2:
				System.out.println("支持模糊查找");
				seachByAge();
				break;
			// 通过性别搜索
			case 3:
				System.out.println("支持模糊查找");
				seachBySex();
				break;
			// 通过电话搜索
			case 4:
				System.out.println("支持模糊查找");
				searchByPhone();
				break;
			// 通过地址搜索
			case 5:
				System.out.println("支持模糊查找");
				seachByAdress();
				break;

			// 显示全部联系人
			case 6:
				showAll();
				break;
			// 返回上一层
			default:
				return;
			}// 结束选择
		} // 结束循环
	}// 结束方法

	// 修改业务逻辑
	public void modifyLogic() throws Exception {
		// 开始while循环
		while (true) {
			// 显示一级修改菜单
			m.modifyMenu();
			// 判断并接收用户输入
			int key = tnr.menuRegex(1, 3);
			// 判断选项
			switch (key) {
			// 显示所有联系人
			case 1:
				showAll();
				break;
			// 显示修改二级菜单
			case 2:
				modifyLogic2();

				break;
			// 返回上一层
			default:
				return;
			}// 结束选择
		} // 结束循环
	}// 结束方法
		// 修改联系人二级菜单

	private void showAll()  {
		db.selectAll(";");

	}

	public void modifyLogic2()  {
		// while循环

		while (true) {
			// 显示二级修改菜单
			m.modifyMenu2();
			// 判断并接受用户输入
			int key = tnr.menuRegex(1, 6);
			// 判断选项
			switch (key) {
			// 修改姓名
			case 1:
				showAll();
				modifyName();
				break;
			// 修改年龄
			case 2:
				showAll();
				modifyAge();
				break;
			// 修改性别
			case 3:
				showAll();
				modifySex();
				break;
			// 修改电话号码
			case 4:
				showAll();
				modifyPhone();
				break;
			// 修改地址
			case 5:
				showAll();
				modifyAdress();
				break;
			// 返回上一层
			case 6:
				showAll();
			default:
				return;
			}
		}
	}

	// 删除业务逻辑
	public void deleteLogic()  {

		// while循环开始
		while (true) {
			// 显示删除菜单
			m.deleteMenu();
			// 判断并接收用户输入
			int key = tnr.menuRegex(1, 4);
			// 判断选项
			switch (key) {
			// 显示所有联系人
			case 1:
				showAll();
				break;
			// 删除单个联系人
			case 2:
				showAll();
				deleteOne();
				break;
			// 删除全部联系人
			case 3:
				deleteAll();
				break;
			// 返回上一层
			default:
				return;
			}// 结束选择
		}
	}

	// 排序业务逻辑
	public void orderLogic()  {

		// 开始循环
		while (true) {
			// 显示排序菜单
			m.orderMenu();
			// 判断并接收用户输入
			int key = tnr.menuRegex(1, 5);
			// 判断选项
			switch (key) {
			// 通过姓名排序
			case 1:
				orderByName();
				break;
			// 通过年龄排序
			case 2:
				orderByAge();
				break;
			// 通过性别排序
			case 3:
				orderBySex();
				break;
			// 显示全部联系人
			case 4:
				showAll();
				break;
			// 返回上一层
			default:
				return;
			}// 结束选择
		} // 结束循环
	}// 结束方法

	// 添加记录操作
	public void addOperation() {
		// 把一个联系人的姓名、年龄等信息封装到一个Person对象中
		TelNoteRegex tnr = new TelNoteRegex();
		String nameTemp = tnr.nameRegex();
		String ageTemp = tnr.ageRegex();
		String sexTemp = tnr.sexRegex();
		String telNumTemp = tnr.telNumRegex();
		String addressTemp = tnr.addressRegex();
		p = new Person(nameTemp, ageTemp, sexTemp, telNumTemp, addressTemp);
		try {
			db.insert(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 通过姓名查找的方法
	public void seachByName() {
		String name = tnr.nameRegex();
		sql = "where name like '%" + name + "%'";
		db.selectAll(sql);

	}

	// 通过年龄查找
	public void seachByAge()   {
		String age = tnr.ageRegex();
		sql = "where age = '" + age + "'";
		db.selectAll(sql);

	}

	// 通过性别查找
	public void seachBySex()   {
		String sex = tnr.sexRegex();
		sql = "where sex like '%" + sex + "%'";
		db.selectAll(sql);

	}

	// 通过地址查找
	public void seachByAdress()   {
		String address = tnr.addressRegex();
		sql = "where adress like '%" + address + "%'";
		db.selectAll(sql);

	}

	// 通过手机号查找
	public void searchByPhone()   {
		String phone = tnr.telNumRegex();
		sql = "where telnum like '%" + phone + "%'";
		db.selectAll(sql);

	}

	// 按姓名排序
	public void orderByName()   {

		sql = "order by name;";
		db.selectAll(sql);

	}

	// 按性别排序
	public void orderBySex()  {
		sql = "order by sex;";
		db.selectAll(sql);

	}

	// 按年龄排序
	public void orderByAge()  {
		sql = "order by age;";
		db.selectAll(sql);

	}

	// 修改的实现
	public int modifyPersonNum() {
		return db.personSum();
	}

	// 修改姓名
	public void modifyName()  {
		getPerson();
		System.out.println("请输入姓名");
		String name = tnr.nameRegex();
		p.setName(name);
		db.update(p);
		System.out.println("修改成功!");

	}

	// 修改性别
	private void modifySex()  {
		getPerson();
		System.out.println("请输入性别:");
		String sex = tnr.sexRegex();
		p.setSex(sex);
		db.update(p);
		System.out.println("修改成功!");
	}

	// 修改年龄
	public void modifyAge() {
		getPerson();
		System.out.println("");
	}

	// 修改地址
	public void modifyAdress() {
		getPerson();
		int i = modifyPersonNum();
		if (i > 0) {
			tnr.menuRegex(1, i);

			System.out.println("修改成功!");
		}
	}

	// 修改手机号
	public void modifyPhone() {
		getPerson();
		int i = modifyPersonNum();
		if (i > 0) {
			tnr.menuRegex(1, i);

			System.out.println("修改成功!");
		}
	}

	// 删除单个联系人
	public void deleteOne() {
		int dp = tnr.menuRegex(1, db.getId());
		db.delete(dp);
		// db.setId(dp);

	}

	// 删除所有联系人
	public void deleteAll() {

	}

	public void getPerson()  {
		System.out.println("请选择要修改的id");
		int i = modifyPersonNum();
		int cp = 0;
		ResultSet ps = null;
		if (i > 0) {
			cp = tnr.menuRegex(1, db.getId());
			ps = db.selectAll("where id =" + cp);
		}
		try {
			if (ps.next()) {
				p.setName(ps.getString("name"));
				p.setAge(ps.getString("age"));
				p.setSex(ps.getString("sex"));
				p.setId(ps.getInt("id"));
				p.setAddress(ps.getString("adress"));
				p.setTelNum(ps.getString("telnum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
