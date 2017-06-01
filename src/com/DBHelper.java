package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHelper {
	public int insert(Person p) throws Exception {
		Connection connection = null;
		String sql = "insert into persons(id,name,age,sex,telnum,adress) values (0,?,?,?,?,?)";
		int i = 0;
		try {
			connection = DBDao.getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, p.getName());
			pst.setString(2, p.getAge());
			pst.setString(3, p.getSex());
			pst.setString(4, p.getTelNum());
			pst.setString(5, p.getAddress());
			i = pst.executeUpdate();
			System.out.println(p.getName() + "成功");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBDao.myClose(null, null, connection);
		}
		return i;
	}

	public int update(Person p) {
		String sql = " update persons set name =? ,sex = ?,age = ?,telNum = ?,adress = ? where id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		int i = 0;
		try {
			conn = DBDao.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, p.getName());
			pstm.setString(2, p.getSex());
			pstm.setString(3, p.getAge());
			pstm.setString(4, p.getTelNum());
			pstm.setString(5, p.getAddress());
			pstm.setInt(6, p.getId());
			i = pstm.executeUpdate();
			System.out.println("修改成功");
		} catch (Exception e) {
		} finally {
			DBDao.myClose(null, pstm, conn);
		}
		return i;
	}

	public int getId() {
		String sql = " select max(id) from persons ";
		Connection conn = null;
		PreparedStatement pstm = null;
		int i = 0;
		try {
			conn = DBDao.getConnection();
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			if (rs.next())
				i = rs.getInt("max(id)");
			System.out.println("成功");
		} catch (Exception e) {
		} finally {
			DBDao.myClose(null, pstm, conn);
		}
		return i;
	}

	public ResultSet selectAll(String str) {
		String sql = "select id,name,age,sex,telnum,adress from persons " + str;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DBDao.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			int id = 0;
			String name = "";
			String sex = "";
			String age = "";
			String tel = "";
			String add = "";
			System.out.println("你请求的结果为:");
			System.out.println(
					"==============================================================================================================");
			System.out.println("id\t\t姓名\t\t性别\t\t年龄\t\t电话\t\t地址");
			while (rs.next()) {
				id = rs.getInt("id");
				name = rs.getString("name");
				sex = rs.getString("sex");
				age = rs.getString("age");
				tel = rs.getString("telnum");
				add = rs.getString("adress");
				System.out.println(id + "\t\t" + name + "\t\t" + sex + "\t\t" + age + "\t\t" + tel + "\t\t" + add);
			}
			System.out.println(
					"==========================================================================================================");
		} catch (Exception e) {

		}
		return rs;
	}

	public int delete(int id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		String sql = "delete from persons where id =?";
		int i = 0;
		try {
			conn = DBDao.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			i = pstm.executeUpdate();

		} catch (Exception e) {
		} finally {
			DBDao.myClose(null, pstm, conn);
		}
		return i;
	}

	public int deleteAll() {
		Connection conn = null;
		PreparedStatement pstm = null;
		String sql = "delete from person ";
		int i = 0;
		try {
			conn = DBDao.getConnection();
			pstm = conn.prepareStatement(sql);
			i = pstm.executeUpdate();
		} catch (Exception e) {
		} finally {
			DBDao.myClose(null, (PreparedStatement) pstm, conn);
		}
		return i;
	}

	public int personSum() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rSet = null;
		String sql = "select count(*) from persons";
		int i = 0;
		try {
			conn = DBDao.getConnection();
			pstm = conn.prepareStatement(sql);
			rSet = pstm.executeQuery();
			if (rSet.next()) {
				i = rSet.getInt("count(*)");
			}

		} catch (Exception e) {
		} finally {
			DBDao.myClose(null, pstm, conn);
		}
		return i;
	}

	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String str = "jdbc:mysql://localhost:3306/test";
			conn = (Connection) DriverManager.getConnection(str, "root", "123456");

		} catch (Exception e) {
		}
		return conn;
	}

}
