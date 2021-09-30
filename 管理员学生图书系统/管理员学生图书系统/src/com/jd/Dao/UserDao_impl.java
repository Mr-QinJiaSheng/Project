package com.jd.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jd.bean.User;
import com.jd.jdbc.Dbutil;

public class UserDao_impl implements UserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	private static final String SQL_USER_LOGIN = "select type from info where uname=? and upass=?";
	private static final String SQL_USER_INSERT = "insert info(uname,upass,type) values(?,?,2)";
	private static final String SQL_USER_DELETE = "delete from info where uname=?";
	private static final String SQL_USER_SELECT="select * from info where uname=?";
	private static final String SQL_USER_UPDATE="update info set upass=? where uname=?";

	@Override
	public int login(User user) {
		// 连接数据库，创建连接对象
		conn = Dbutil.getConn();
		int type = 0; // 用户权限
		try {
			// 创建预编译环境
			ps = conn.prepareStatement(SQL_USER_LOGIN);
			// 设置sql语句中的参数
			ps.setString(1, user.getUname());
			ps.setString(2, user.getUpass());

			// 执行sql语句
			rs = ps.executeQuery();
			// 读取结果集信息
			while (rs.next()) {
				type = rs.getInt("type");
				return type;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbutil.close(conn, ps, rs);
		}
		return -1;
	}

	@Override
	public boolean insert(User user) {
		// 连接数据库
		conn = Dbutil.getConn();

		try {
			ps = conn.prepareStatement(SQL_USER_INSERT);

			ps.setString(1, user.getUname());
			ps.setString(2, user.getUpass());

			int n = ps.executeUpdate();

			if (n > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbutil.close(conn, ps, rs);
		}
		return false;
	}

	@Override
	public boolean delete(String uname) {
		// 连接
		conn = Dbutil.getConn();

		try {
			// 执行环境
			ps = conn.prepareStatement(SQL_USER_DELETE);
			ps.setString(1, uname);

			int n = ps.executeUpdate();

			if (n > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbutil.close(conn, ps, rs);
		}
		return false;
	}

	@Override
	public boolean update(User user) {
		// 连接数据库
		conn=Dbutil.getConn();		
		
		try {
			//创建预编译环境
			ps=conn.prepareStatement(SQL_USER_UPDATE);
			//设置sql语句中的参数
			ps.setString(1, user.getUpass());
			ps.setString(2, user.getUname());
			
			int n=ps.executeUpdate();
			
			if(n>0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Dbutil.close(conn, ps, rs);
		}
		return false;
	}

	@Override
	public User select(String uname) {
		User user=null;
		// 连接数据库
		conn=Dbutil.getConn();
		
		try {
			ps=conn.prepareStatement(SQL_USER_SELECT);
			ps.setString(1, uname);			
			rs=ps.executeQuery();			
			while(rs.next()) {
				user=new User();
				user.setId(rs.getInt("id"));
				user.setUname(rs.getString("uname"));
				user.setUpass(rs.getString("upass"));
				user.setType(rs.getInt("type"));
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Dbutil.close(conn, ps, rs);
		}		
		return user;
	}

}
