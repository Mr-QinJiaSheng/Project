package com.jd.bean;

public class User {
	 /*
	  * ÿһ�����ݱ��Ӧһ��ʵ����
	  * ʵ�����е����Ծ������ݱ����ֶ�
	  * */
	private int id;
	private String uname;
	private String upass;
	private int type;
	
	//���캯��
	public User() {
	}

	public User(String uname, String upass) {
		this.uname = uname;
		this.upass = upass;
	}

	public User(String uname, String upass, int type) {
		this.uname = uname;
		this.upass = upass;
		this.type = type;
	}

	public User(int id, String uname, String upass, int type) {
		this.id = id;
		this.uname = uname;
		this.upass = upass;
		this.type = type;
	}
	
	
	//��װ
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", upass=" + upass + ", type=" + type + "]";
	}
	
	
	
	

}
