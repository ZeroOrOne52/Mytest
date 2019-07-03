package com.smbms.dao;

import java.util.List;
import java.util.Map;

import com.smbms.entity.User;

public interface UserMapper {

	/**
	 * ��������ѯ
	 * @param map
	 * @return
	 */
	List<User> findUserByCondition(Map<String, Object> map);
	
	/**
	 * trim��ǩ��̬��ѯ
	 * @param map
	 * @return
	 */
	List<User> findUserWithTrim(Map<String, Object> map);
	
	/**
	 * �޸��û�
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	
	/**
	 * ���ݽ�ɫid�����ѯ�ý�ɫ�����е��û���Ϣ
	 * @param roleIds
	 * @return
	 */
	List<User> findUserListWithArray(Integer[] roleIds);
	
	/**
	 * ���ݽ�ɫid�����ѯ�ý�ɫ�����е��û���Ϣ
	 * @param roleList
	 * @return
	 */
	List<User> findUserListWithList(List<Integer> roleList );
	
	/**
	 * ���ݽ�ɫid�����ѯ�ý�ɫ�����е��û���Ϣ
	 * @param map
	 * @return
	 */
	List<User> findUserListWithMap(Map<String, Object> map);
 	
	
	/**
	 * ��ҳ��ѯ
	 * @param map
	 * @return
	 */
	List<User> findUserListByPage(Map<String, Object> map);
	
	List<User> findUserListWithChoose(Map<String, Object> map);
}
