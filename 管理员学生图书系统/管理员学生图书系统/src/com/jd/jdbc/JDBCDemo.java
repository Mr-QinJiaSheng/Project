package com.jd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

public class JDBCDemo {
	
	private static String URL="jdbc:sqlserver://localhost:1433;DataBaseName=���ݿ�DB";
	private static String USerName="sa";
	private static String PASSWORD="123456";
	private static String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static void main(String[] args) {
		try {
			//��������
			Class.forName(DRIVER);
			//��������
			Connection conn=DriverManager.getConnection(URL, USerName, PASSWORD);
			//���������Ƿ�ɹ�
			if(conn!=null) {
				System.out.println("���ӳɹ�");
			}else {
				System.out.println("����ʧ��");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
