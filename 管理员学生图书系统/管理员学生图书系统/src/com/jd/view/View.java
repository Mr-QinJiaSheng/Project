package com.jd.view;

import java.util.Scanner;

import com.jd.bean.User;
import com.jd.ui.MainUi;

public class View {
	private static Scanner input=new Scanner(System.in);

	public static User indexView() {
		System.out.println("*********************************");
		System.out.println("******\tͼ�����ϵͳ******");
		System.out.println("******\t�������ʾ����************");
		System.out.println("******\t�������ʺ�:**********");
		String uName=input.next();
		System.out.println("******\t���������룺****************");
		String uPwd=input.next();
		return new User(uName,uPwd);
	}
	
	//����Ա�˵�
	public static int managerMenuView() {
		System.out.println("*********************************");
		System.out.println("******\t��ӭ����Ա�ؼ�******");
		System.out.println("******\t�������ʾ����************");
		System.out.println("******\t0.�˳�**********");
		System.out.println("******\t1.����ѧ����Ϣ**********");
		System.out.println("******\t2.ɾ��ѧ����Ϣ**********");
		System.out.println("******\t3.�޸�ѧ����Ϣ**********");
		System.out.println("******\t4.��ѯѧ����Ϣ**********");
		System.out.println("*********************************");
		System.out.print("��ѡ��");
		
		//��ȡ�û��������Ϣ
		int choice=input.nextInt();
		
		//�ж��û������Ƿ���0-4֮��
		if(choice<0 || choice>4) {
			System.out.println("�������");
			return managerMenuView(); //�ص�
		}else if(choice==0) {
			System.out.println("�ɹ��˳�");
		}
		return choice;		
	}
	
	//ѧ���˵� 
	public static int stuMenuView() {
		System.out.println("*********************************");
		System.out.println("******\t��ӭ����ѧ��ͼ��ϵͳ\t******");
		System.out.println("******\t�������ʾ����\t************");
		System.out.println("******\t0.�˳�\t**********");
		System.out.println("******\t1 : ��ѯ����ͼ��\t**********");
		System.out.println("******\t2 : ����ͼ���Ų�ѯͼ��\t**********");
		System.out.println("*********************************");
		System.out.print("��ѡ��");
		//����������Ϣ
		int choice=input.nextInt();
		MainUi mainui = new MainUi();
		//���������ֵ�����ж�
		if(choice<0 || choice>2) {
			System.out.println("�������");
			return stuMenuView(); //�ص�
		}else if(choice==1) {
			mainui.queryAllBook();
		}else if(choice==2) {
			mainui.queryBookById();
			return stuMenuView();
		}else if(choice==0) {
			System.out.println("�ɹ��˳�");
		}
		return choice;		
		
	}
	
	//�޸�ѧ����Ϣ�˵�
	public static User updateMenuView() {
		System.out.println("*********************************");
		System.out.println("******\t�������ʾ����\t******");
		System.out.println("******\t������Ҫ�޸ĵ��ʺţ�\t************");
		//����������ʺ�
		String updateName = input.next();
		 
		System.out.println("******\t������Ҫ�µ����룺\t************");
		//����������µ����룺
		String NewPwd=input.next();
		System.out.println("*********************************");
		
		return new User(updateName,NewPwd);
	}
	
	//���ѧ����Ϣ
	public static void printShow(User user) {
		System.out.println("�û�ID:"+user.getId());
		System.out.println("�û�����"+user.getUname());
		System.out.println("�û����룺"+user.getUpass());
		if(user.getType()==1) {
			System.out.println("�û�Ȩ�ޣ�����Ա");
		}else {
			System.out.println("�û�Ȩ�ޣ�ѧ��");
		}
	}
	
	//��ѯѧ����Ϣ
	public static String selectMenuView() {
		System.out.println("*********************************");
		System.out.println("******\t�������ʾ����\t******");
		System.out.println("������Ҫ��ѯ��ѧ���ʺţ�");
		String SeleName=input.next();
		
		System.out.println("*********************************");
		return SeleName;
	}
	
	//ɾ��ѧ����Ϣ
	public static String deleteMenuView() {
		System.out.println("*********************************");
		System.out.println("******\t�������ʾ����\t******");
		System.out.println("������Ҫɾ����ѧ���ʺţ�");
		String deleName=input.next();
		
		System.out.println("*********************************");
		return deleName;
	}
	
	//���ѧ����Ϣ
	public static User addMenuView() {
		System.out.println("*********************************");
		System.out.println("******\t�������ʾ����\t******");
		System.out.println("����������ӵ��ʺţ�");
		String AddName=input.next();
		
		System.out.println("����������ӵ����룺");
		String AddPwe=input.next();
		
		System.out.println("*********************************");
		return new User(AddName,AddPwe);
		
	}
	
}
