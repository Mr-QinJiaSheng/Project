package com.jd.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.jd.view.View;
import com.jd.Dao.UserDao;
import com.jd.Dao.UserDao_impl;
import com.jd.Dao.Bookdao;
import com.jd.bean.User;
import com.jd.vos.Book;

public class MainUi {
	public static UserDao ud = new UserDao_impl();
	public static boolean flag;
	static Scanner in = new Scanner(System.in);
	Bookdao dao = new Bookdao();
    //打印界面
	public void print() {
		System.out.println("*****************");
		System.out.println("1 : 添加图书");
		System.out.println("2 : 查询所有图书");
		System.out.println("3 : 根据图书编号查询图书");
		System.out.println("4 : 修改图书");
		System.out.println("5 : 删除图书");
		System.out.println("0 : 退出");
	}
    //添加图书
	public void addBook() {
		System.out.println("请输入图书的编号");
		int id = in.nextInt();
		System.out.println("请输入图书的名称");
		String name = in.next();
		System.out.println("请输入图书的价钱");
		float price = in.nextFloat();
		Book book = new Book(name, price);
		boolean flag = dao.addBook(book);
		if (flag) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}

	}
	
    //查询所有图书
	public void queryAllBook() {
		ArrayList<Book> list = dao.queryAllBook();
		for (int i = 0; i < list.size(); i++) {
			int id = list.get(i).getId();
			String name = list.get(i).getName();
			float price = list.get(i).getPrice();
			System.out.println("编号：" + id + "，书名：" + name + "，价格：" + price);
		}
	}
    //根据编号查询图书
	public void queryBookById() {
		System.out.println("请输入要查询的书号");
		int id = in.nextInt();
		Book bk = dao.queryBookById(id);
		if (bk != null) {
			System.out.println("编号：" + bk.getId() + "，书名：" + bk.getName()
					+ "，价格：" + bk.getPrice());
		} else {
			System.out.println("查找的图书不存在");
		}

	}

	// 修改图书
	public void modifyBook() {
		System.out.println("请输入要修改的图书的编号");
		int id = in.nextInt();
		System.out.println("请输入新的书名");
		String name = in.next();
		System.out.println("请输入新的价格");
		float price = in.nextFloat();
		int ret = dao.modifyBook(id, name, price);
		if (ret == 1) {
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");
		}

	}

	// 删除图书
	public void deleteBook() {
		System.out.println("请输入如要删除的图书的图书号");
		int id = in.nextInt();
		int ret = dao.deleteBook(id);
		if (ret == 1) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除的图书不存在");
		}

	}

	public static void main(String[] args) {
		MainUi mainui = new MainUi();
		while (true) {
			// 给用户展示登录页面
			User user = View.indexView();
			int i = ud.login(user); // 调用login()对象，根据返回值判断是管理员还是学生
			switch (i) {
			case 1:	
				mainui.choice1();
				break;
			case 2:
				System.out.println("恭喜学生登录成功");
				StudentServer();
				break;
			case -1:
				System.out.println("结果错误");
				break;
			}
		}
	}
	// 学生业务
	private static void StudentServer() {
		int Choice = View.stuMenuView();
		switch (Choice) {
		case 0:
			System.exit(-1); // 退出当前系统
			break;
		case 1:
			MainUi mainui = new MainUi();
			System.out.println( "请你选泽想要的书籍，输入编号：" );
			mainui.queryBookById();
			System.out.println( "购买成功！！！" );
			View.stuMenuView();
			break;
		default:
			System.out.println("欢迎使用图书查询，前来购买！");
			break;
		}
	}
	// 管理员业务
	private static void managerServer() {
		while (true) {
			int manageChoice = View.managerMenuView();
			switch (manageChoice) {
			case 0:
				System.exit(-1); // 退出当前系统
				break;
			case 1:
				User Adduser = View.addMenuView();
				flag = ud.insert(Adduser);
				System.out.println(flag ? "添加成功" : "添加失败");
				break;
			case 2:
				String deleteName = View.deleteMenuView();
				flag = ud.delete(deleteName);
				System.out.println(flag ? "删除成功" : "删除失败");
				break;
			case 3:
				User Updateuser = View.updateMenuView();
				flag = ud.update(Updateuser);
				System.out.println(flag ? "修改成功" : "修改失败");
				break;
			case 4:
				String selectName = View.selectMenuView();				
				User SelectUser = ud.select(selectName);
				View.printShow(SelectUser);
				break;
			default:
				System.out.println("输入有误，请重新选择");
				break;
			}
		}
	}
	public void choice1() {
		MainUi mainui = new MainUi();
		System.out.println("恭喜管理员登录成功");
	    System.out.println("1.图书管理  2.学生管理");
		int a = in.nextInt();
		if (a==1) {
			while (true) {
				mainui.print();
				System.out.println("请选择你要进行的操作");
				int choice = in.nextInt();
				switch (choice) {
				case 1:
					mainui.addBook();
					break;
				case 2:
					mainui.queryAllBook();
					break;
				case 3:
					mainui.queryBookById();
					break;
				case 4:
					mainui.modifyBook();
					break;
				case 5:
					mainui.deleteBook();
					break;
				case 0:
					System.out.println("成功退出");
					System.exit(-1);
					break;
				}
			}
		}else if (a==2) {
		managerServer();
		}
		}

}
