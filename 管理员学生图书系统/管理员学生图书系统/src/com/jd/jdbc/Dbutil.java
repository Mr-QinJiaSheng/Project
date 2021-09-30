package com.jd.jdbc;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
public class Dbutil {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	//静态语句块
	static {
		//JDBCUtils.class  获得对象
		//getClassLoader() 类加载器
		//getResourceAsStream("jdbc.properties") 加载资源文件放到输入流中
		InputStream is = Dbutil.class.getClassLoader().getResourceAsStream("jdbc.properties");
		//创建property类型的对象
		Properties p=new Properties();
		
		//加载流文件
		try {
			p.load(is);
			driver=p.getProperty("driver");
			url=p.getProperty("url");			
			username=p.getProperty("user");
			password=p.getProperty("password");
			Class.forName(driver); //加载驱动
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获得连接对象的方法
	public static Connection getConn() {
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
	//资源释放
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

