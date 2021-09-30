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
    //��ӡ����
	public void print() {
		System.out.println("*****************");
		System.out.println("1 : ���ͼ��");
		System.out.println("2 : ��ѯ����ͼ��");
		System.out.println("3 : ����ͼ���Ų�ѯͼ��");
		System.out.println("4 : �޸�ͼ��");
		System.out.println("5 : ɾ��ͼ��");
		System.out.println("0 : �˳�");
	}
    //���ͼ��
	public void addBook() {
		System.out.println("������ͼ��ı��");
		int id = in.nextInt();
		System.out.println("������ͼ�������");
		String name = in.next();
		System.out.println("������ͼ��ļ�Ǯ");
		float price = in.nextFloat();
		Book book = new Book(name, price);
		boolean flag = dao.addBook(book);
		if (flag) {
			System.out.println("��ӳɹ�");
		} else {
			System.out.println("���ʧ��");
		}

	}
	
    //��ѯ����ͼ��
	public void queryAllBook() {
		ArrayList<Book> list = dao.queryAllBook();
		for (int i = 0; i < list.size(); i++) {
			int id = list.get(i).getId();
			String name = list.get(i).getName();
			float price = list.get(i).getPrice();
			System.out.println("��ţ�" + id + "��������" + name + "���۸�" + price);
		}
	}
    //���ݱ�Ų�ѯͼ��
	public void queryBookById() {
		System.out.println("������Ҫ��ѯ�����");
		int id = in.nextInt();
		Book bk = dao.queryBookById(id);
		if (bk != null) {
			System.out.println("��ţ�" + bk.getId() + "��������" + bk.getName()
					+ "���۸�" + bk.getPrice());
		} else {
			System.out.println("���ҵ�ͼ�鲻����");
		}

	}

	// �޸�ͼ��
	public void modifyBook() {
		System.out.println("������Ҫ�޸ĵ�ͼ��ı��");
		int id = in.nextInt();
		System.out.println("�������µ�����");
		String name = in.next();
		System.out.println("�������µļ۸�");
		float price = in.nextFloat();
		int ret = dao.modifyBook(id, name, price);
		if (ret == 1) {
			System.out.println("�޸ĳɹ�");
		} else {
			System.out.println("�޸�ʧ��");
		}

	}

	// ɾ��ͼ��
	public void deleteBook() {
		System.out.println("��������Ҫɾ����ͼ���ͼ���");
		int id = in.nextInt();
		int ret = dao.deleteBook(id);
		if (ret == 1) {
			System.out.println("ɾ���ɹ�");
		} else {
			System.out.println("ɾ����ͼ�鲻����");
		}

	}

	public static void main(String[] args) {
		MainUi mainui = new MainUi();
		while (true) {
			// ���û�չʾ��¼ҳ��
			User user = View.indexView();
			int i = ud.login(user); // ����login()���󣬸��ݷ���ֵ�ж��ǹ���Ա����ѧ��
			switch (i) {
			case 1:	
				mainui.choice1();
				break;
			case 2:
				System.out.println("��ϲѧ����¼�ɹ�");
				StudentServer();
				break;
			case -1:
				System.out.println("�������");
				break;
			}
		}
	}
	// ѧ��ҵ��
	private static void StudentServer() {
		int Choice = View.stuMenuView();
		switch (Choice) {
		case 0:
			System.exit(-1); // �˳���ǰϵͳ
			break;
		case 1:
			MainUi mainui = new MainUi();
			System.out.println( "����ѡ����Ҫ���鼮�������ţ�" );
			mainui.queryBookById();
			System.out.println( "����ɹ�������" );
			View.stuMenuView();
			break;
		default:
			System.out.println("��ӭʹ��ͼ���ѯ��ǰ������");
			break;
		}
	}
	// ����Աҵ��
	private static void managerServer() {
		while (true) {
			int manageChoice = View.managerMenuView();
			switch (manageChoice) {
			case 0:
				System.exit(-1); // �˳���ǰϵͳ
				break;
			case 1:
				User Adduser = View.addMenuView();
				flag = ud.insert(Adduser);
				System.out.println(flag ? "��ӳɹ�" : "���ʧ��");
				break;
			case 2:
				String deleteName = View.deleteMenuView();
				flag = ud.delete(deleteName);
				System.out.println(flag ? "ɾ���ɹ�" : "ɾ��ʧ��");
				break;
			case 3:
				User Updateuser = View.updateMenuView();
				flag = ud.update(Updateuser);
				System.out.println(flag ? "�޸ĳɹ�" : "�޸�ʧ��");
				break;
			case 4:
				String selectName = View.selectMenuView();				
				User SelectUser = ud.select(selectName);
				View.printShow(SelectUser);
				break;
			default:
				System.out.println("��������������ѡ��");
				break;
			}
		}
	}
	public void choice1() {
		MainUi mainui = new MainUi();
		System.out.println("��ϲ����Ա��¼�ɹ�");
	    System.out.println("1.ͼ�����  2.ѧ������");
		int a = in.nextInt();
		if (a==1) {
			while (true) {
				mainui.print();
				System.out.println("��ѡ����Ҫ���еĲ���");
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
					System.out.println("�ɹ��˳�");
					System.exit(-1);
					break;
				}
			}
		}else if (a==2) {
		managerServer();
		}
		}

}
