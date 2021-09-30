package com.jd.Dao;
import com.jd.bean.User;
public interface UserDao {
	/**
	 * 登录
	 * uname,upass
	 * @rturn int类型 -1登录失败，1管理员，2学生
	 */
	int login(User user);
	/**
	 * 添加学生信息
	 * @param User uname,upass
	 * @return true:成功     false:失败
	 */
	boolean insert(User user);
	/**
	 * 删除学生信息
	 * 
	 */
	boolean delete(String uname);
	/**
	 * 修改学生信息
	 */
	boolean update(User user);
	/**
	 * 查询学生信息
	 */
	User select(String uname);
}
