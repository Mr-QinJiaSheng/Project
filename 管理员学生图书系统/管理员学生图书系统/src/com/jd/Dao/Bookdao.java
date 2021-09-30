package com.jd.Dao;

import java.sql.*;
import java.util.ArrayList;
import com.jd.jdbc.Dbutil;
import com.jd.vos.Book;

public class Bookdao {
	// 添加图书
   public boolean addBook(Book book) {
		boolean result = false;
		Connection conn =Dbutil.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into book(name,price) values(?,?)");
			ps.setString(1, book.getName());
			ps.setFloat(2, book.getPrice());
			ps.execute();
			result = true;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return result;
	}

// 根据图书的编号查询图书
	public Book queryBookById(int id) {
		Connection conn = Dbutil.getConn();
		Book book = null;

		try {
			PreparedStatement ps = conn
					.prepareStatement("select id,name,price from book where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				book = new Book(rs.getInt(1), rs.getString(2), rs.getFloat(3));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return book;

	}

	// 根据图书编号删除图书
	public int deleteBook(int id) {

		Connection conn = Dbutil.getConn();
		int ret = 0;
		try {
			PreparedStatement ps = conn
					.prepareStatement("delete from book where id = ?");
			ps.setInt(1, id);
			ret = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ret;
	}

	// 修改图书
	public int modifyBook(int id, String name, float price) {
		Connection conn = Dbutil.getConn();
		int ret = 0;
		try {
			PreparedStatement ps = conn
					.prepareStatement("update book set name=? , price=? where id =?");
			ps.setString(1, name);
			ps.setFloat(2, price);
			ps.setInt(3, id);
			ret = ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ret;

	}

	// 查询所有图书
	public ArrayList<Book> queryAllBook() {
		ArrayList<Book> list = new ArrayList<Book>();
		Connection conn = Dbutil.getConn();

		try {
			PreparedStatement ps = conn.prepareStatement("select * from book");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				float price = rs.getFloat(3);
				Book book = new Book(id, name, price);
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
