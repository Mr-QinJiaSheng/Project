package com.jd.view;

import java.util.Scanner;

import com.jd.bean.User;
import com.jd.ui.MainUi;

public class View {
	private static Scanner input=new Scanner(System.in);

	public static User indexView() {
		System.out.println("*********************************");
		System.out.println("******\t图书管理系统******");
		System.out.println("******\t请根据提示操作************");
		System.out.println("******\t请输入帐号:**********");
		String uName=input.next();
		System.out.println("******\t请输入密码：****************");
		String uPwd=input.next();
		return new User(uName,uPwd);
	}
	
	//管理员菜单
	public static int managerMenuView() {
		System.out.println("*********************************");
		System.out.println("******\t欢迎管理员回家******");
		System.out.println("******\t请根据提示操作************");
		System.out.println("******\t0.退出**********");
		System.out.println("******\t1.增加学生信息**********");
		System.out.println("******\t2.删除学生信息**********");
		System.out.println("******\t3.修改学生信息**********");
		System.out.println("******\t4.查询学生信息**********");
		System.out.println("*********************************");
		System.out.print("请选择：");
		
		//获取用户输入的信息
		int choice=input.nextInt();
		
		//判断用户输入是否在0-4之间
		if(choice<0 || choice>4) {
			System.out.println("输入错误");
			return managerMenuView(); //回调
		}else if(choice==0) {
			System.out.println("成功退出");
		}
		return choice;		
	}
	
	//学生菜单 
	public static int stuMenuView() {
		System.out.println("*********************************");
		System.out.println("******\t欢迎来到学生图书系统\t******");
		System.out.println("******\t请根据提示操作\t************");
		System.out.println("******\t0.退出\t**********");
		System.out.println("******\t1 : 查询所有图书\t**********");
		System.out.println("******\t2 : 根据图书编号查询图书\t**********");
		System.out.println("*********************************");
		System.out.print("请选择：");
		//接收输入信息
		int choice=input.nextInt();
		MainUi mainui = new MainUi();
		//对所输入的值进行判断
		if(choice<0 || choice>2) {
			System.out.println("输入错误");
			return stuMenuView(); //回调
		}else if(choice==1) {
			mainui.queryAllBook();
		}else if(choice==2) {
			mainui.queryBookById();
			return stuMenuView();
		}else if(choice==0) {
			System.out.println("成功退出");
		}
		return choice;		
		
	}
	
	//修改学生信息菜单
	public static User updateMenuView() {
		System.out.println("*********************************");
		System.out.println("******\t请根据提示操作\t******");
		System.out.println("******\t请输入要修改的帐号：\t************");
		//接收输入的帐号
		String updateName = input.next();
		 
		System.out.println("******\t请输入要新的密码：\t************");
		//接收输入的新的密码：
		String NewPwd=input.next();
		System.out.println("*********************************");
		
		return new User(updateName,NewPwd);
	}
	
	//输出学生信息
	public static void printShow(User user) {
		System.out.println("用户ID:"+user.getId());
		System.out.println("用户名："+user.getUname());
		System.out.println("用户密码："+user.getUpass());
		if(user.getType()==1) {
			System.out.println("用户权限：管理员");
		}else {
			System.out.println("用户权限：学生");
		}
	}
	
	//查询学生信息
	public static String selectMenuView() {
		System.out.println("*********************************");
		System.out.println("******\t请根据提示操作\t******");
		System.out.println("请输入要查询的学生帐号：");
		String SeleName=input.next();
		
		System.out.println("*********************************");
		return SeleName;
	}
	
	//删除学生信息
	public static String deleteMenuView() {
		System.out.println("*********************************");
		System.out.println("******\t请根据提示操作\t******");
		System.out.println("请输入要删除的学生帐号：");
		String deleName=input.next();
		
		System.out.println("*********************************");
		return deleName;
	}
	
	//添加学生信息
	public static User addMenuView() {
		System.out.println("*********************************");
		System.out.println("******\t请根据提示操作\t******");
		System.out.println("请输入新添加的帐号：");
		String AddName=input.next();
		
		System.out.println("请输入新添加的密码：");
		String AddPwe=input.next();
		
		System.out.println("*********************************");
		return new User(AddName,AddPwe);
		
	}
	
}
