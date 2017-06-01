package com;

import java.io.Serializable;

public class Person implements Serializable{
	private int id;
	private String name;
	private String age;
	private String sex;
	private String telNum;
	private String address;
	
	public Person() {}

	public Person(String name, String age, String sex, String telNum, String address) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.telNum = telNum;
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTelNum() {
		return telNum;
	}
	
	public void setTelNum (String telNum) {
		this.telNum = telNum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//重写Object类的toString方法
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("序号 ").append(id).append("#").append("\t");
		sb.append("姓名 ").append(name).append("\t\t");
		sb.append("年龄 ").append(age).append("\t\t");
		sb.append("性别 ").append(sex).append("\t\t");
		sb.append("电话号码 ").append(telNum).append("\t\t");
		sb.append("住址").append(address);
		return sb.toString();

	
}
	
}







