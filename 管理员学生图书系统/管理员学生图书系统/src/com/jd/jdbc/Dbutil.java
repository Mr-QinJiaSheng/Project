package com.jd.jdbc;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
public class Dbutil {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	//��̬����
	static {
		//JDBCUtils.class  ��ö���
		//getClassLoader() �������
		//getResourceAsStream("jdbc.properties") ������Դ�ļ��ŵ���������
		InputStream is = Dbutil.class.getClassLoader().getResourceAsStream("jdbc.properties");
		//����property���͵Ķ���
		Properties p=new Properties();
		
		//�������ļ�
		try {
			p.load(is);
			driver=p.getProperty("driver");
			url=p.getProperty("url");			
			username=p.getProperty("user");
			password=p.getProperty("password");
			Class.forName(driver); //��������
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//������Ӷ���ķ���
	public static Connection getConn() {
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
	//��Դ�ͷ�
	public static void close(Connection conn,Statement st,ResultSet rs) {
			try {
				if(rs!=null) {
				rs.close();
				rs=null;
				}
				if(st!=null) {
					st.close();
					st=null;
				}
				if(conn!=null) {
					conn.close();
					conn=null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}

