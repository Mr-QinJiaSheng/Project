package com.jd.Dao;
import com.jd.bean.User;
public interface UserDao {
	/**
	 * ��¼
	 * uname,upass
	 * @rturn int���� -1��¼ʧ�ܣ�1����Ա��2ѧ��
	 */
	int login(User user);
	/**
	 * ���ѧ����Ϣ
	 * @param User uname,upass
	 * @return true:�ɹ�     false:ʧ��
	 */
	boolean insert(User user);
	/**
	 * ɾ��ѧ����Ϣ
	 * 
	 */
	boolean delete(String uname);
	/**
	 * �޸�ѧ����Ϣ
	 */
	boolean update(User user);
	/**
	 * ��ѯѧ����Ϣ
	 */
	User select(String uname);
}
