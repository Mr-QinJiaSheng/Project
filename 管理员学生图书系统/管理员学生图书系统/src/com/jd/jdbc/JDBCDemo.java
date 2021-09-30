package com.jd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

public class JDBCDemo {
	
	private static String URL="jdbc:sqlserver://localhost:1433;DataBaseName=数据库DB";
	private static String USerName="sa";
	private static String PASSWORD="123456";
	private static String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static void main(String[] args) {
		try {
			//加载驱动
			Class.forName(DRIVER);
			//建立连接
			Connection conn=DriverManager.getConnection(URL, USerName, PASSWORD);
			//测试连接是否成功
			if(conn!=null) {
				System.out.println("连接成功");
			}else {
				System.out.println("连接失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
