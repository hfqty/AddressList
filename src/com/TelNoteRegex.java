package com;

import java.util.Scanner;

//负责扫描用户的输入(附加验证)
public class TelNoteRegex {

	// 返回用户输入的序号(思考这个方法为什么设计两个形参？？？)
	// 该方法适合所有的菜单选择验证
	public int menuRegex(int min, int max) {

		while (true) {
			System.out.println("请输入正确的数字,最小是: " + min + "\t" + "最大是: " + max);
			String inputStr = getInput();

			if (inputStr.matches("\\d{1,2}")) {
				int i = Integer.parseInt(inputStr);
				if (i >= min && i <= max)
					return i;
				else
					System.err.println("没有该选项号！请重新输入");
			} else {
				System.err.println("只能输入1位数字！");
			}
		}
	}

	// 姓名验证1-10个字母
	public String nameRegex() {

		while (true) {
			System.out.println("输入姓名，中英文");
			String inputStr = getInput().trim();
			if (!"".equals(inputStr) && inputStr.length() < 20) {
				return inputStr;
			} else {
				System.err.println("输入姓名错误，请重新输入！");
			}
		}
	}

	// 年龄验证100+
	public String ageRegex() {
		while (true) {
			System.out.println("输入年龄,1-100+");
			String age = getInput();
			if (age.matches("\\d{1,3}")) {
				if (new Integer(Integer.parseInt(age)) > 0 && new Integer(Integer.parseInt(age)) < 200)
					return age;
			} else {
				System.out.println("年龄输入错误,请重新输入!");
			}
		}

	}

	// 性别验证1位字母
	public String sexRegex() {
		while (true) {
			System.out.println("输入性别,(m or M)(f or F)");
			String sex = getInput();
			if (sex.matches("[mMfF]")) 
				return sex;
			 else 
				System.out.println("性别输入错误,请重新输入!");
		}

	}

	// 电话号码验证6-10个数字
	public String telNumRegex() {
		while (true) {
			System.out.println("输入电话号码,6-10个数字");
			String phone = getInput();
			if (phone.matches("[0-9]{6,10}")) 
				return phone;
			 else 
				System.out.println("电话号码输入错误,请重新输入!");
			
		}
	}

	// 地址验证1-50个字母或数字
	public String addressRegex() {
		while (true) {
			System.out.println("输入地址,1-50个字母或数字");
			String address = getInput();
			if (address.matches("[a-zA-Z0-9]{1,50}")) 
				return address;
			 else 
				System.out.println("地址输入错误,请重新输入!");
			
		}
	}

	@SuppressWarnings("resource")
	public String getInput() {
		return new Scanner(System.in).next();
	}

}
