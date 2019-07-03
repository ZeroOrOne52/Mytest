package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.smbms.dao.UserMapper;
import com.smbms.entity.User;
import com.smbms.utils.MyBatisUtil;

public class TestM {

	@Test
	public void test1() {
		//1.��ȡsession
		SqlSession session = MyBatisUtil.createSqlSession();
		//2.��������
		UserMapper mapper = session.getMapper(UserMapper.class);
		//3.����map���ϱ�����������
		Map<String, Object> map = new HashMap<String, Object>();
		//map.put("userCode", "a");
		//map.put("roleId", 2);
		List<User> list = mapper.findUserByCondition(map);
		//4������
		for (User user : list) {
			System.out.println(user.getUserCode()+","+user.getUserName()+","+user.getUserRole());
		}
	}
	
	
	@Test
	public void test2() {
		//1.��ȡsession
		SqlSession session = MyBatisUtil.createSqlSession();
		//2.��������
		UserMapper mapper = session.getMapper(UserMapper.class);
		//3.����map���ϱ�����������
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userCode", "a");
		map.put("roleId", 2);
		List<User> list = mapper.findUserWithTrim(map);
		//4������
		for (User user : list) {
			System.out.println(user.getUserCode()+","+user.getUserName()+","+user.getUserRole());
		}
	}
	
	
	@Test
	public void test3() {
		//1.��ȡsession
		SqlSession session = MyBatisUtil.createSqlSession();
		try {
			//2.��������
			UserMapper mapper = session.getMapper(UserMapper.class);
			//3.�����û�����
			User user = new User();
			user.setUserName("����");
			user.setGender(2);
			user.setUserRole(3);
			user.setId(19);
			//4.���÷���
			int count  = mapper.updateUser(user);
			if(count>0) {
				System.out.println("�ɹ�");
			}else {
				System.out.println("ʧ�ܣ�");
			}
			//5.�ύ����
			session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//6.�ع�
			session.rollback();
		}finally {
			//7.�ر���Դ
			MyBatisUtil.closeSqlSession(session);
		}
		
	}
	
	@Test
	public void test4() {
		//1.��ȡsession
		SqlSession session = MyBatisUtil.createSqlSession();
		//2.��������
		UserMapper mapper = session.getMapper(UserMapper.class);
		//3.ʹ�����鱣���ɫid
		Integer [] roleIds = {1,2};
		List<User> list = mapper.findUserListWithArray(roleIds);
		//4.����
		for (User user : list) {
			System.out.println(user.getUserCode()+","+user.getUserName()+","+user.getUserRole());
		}
	}
	
	@Test
	public void test5() {
		//1.��ȡsession
		SqlSession session = MyBatisUtil.createSqlSession();
		//2.��������
		UserMapper mapper = session.getMapper(UserMapper.class);
		//3.ʹ��list���ϱ����ɫid
		List<Integer> roleList = new ArrayList<Integer>();
		roleList.add(2);
		roleList.add(3);
		List<User> list = mapper.findUserListWithList(roleList);
		//4.����
		for (User user : list) {
			System.out.println(user.getUserCode()+","+user.getUserName()+","+user.getUserRole());
		}
	}
	@Test
	public void test6() {
		//1.��ȡsession
		SqlSession session = MyBatisUtil.createSqlSession();
		//2.��������
		UserMapper mapper = session.getMapper(UserMapper.class);
		Map<String, Object> map = new HashMap<String, Object>();
		//��ɫid
		List<Integer> roleList = new ArrayList<Integer>();
		roleList.add(2);
		roleList.add(3);
		//��������
		map.put("sex",2);//�Ա�
		map.put("roleIds", roleList);//��ɫid
		List<User> list = mapper.findUserListWithMap(map);
		//4.����
		for (User user : list) {
			System.out.println(user.getUserCode()+","+user.getUserName()+","+user.getUserRole());
		}
	}
	
	@Test
	public void test7() {
		//1.��ȡsession
		SqlSession session = MyBatisUtil.createSqlSession();
		//2.��������
		UserMapper mapper = session.getMapper(UserMapper.class);
		//3.����map���ϱ�����������
		Map<String, Object> map = new HashMap<String, Object>();
		
		int pageIndex = 1;//ҳ��
		int pageSize = 5;//ÿҳ��ʾ������
		
		map.put("start", (pageIndex-1)*pageSize);//(��ǰҳ��-1)*ÿҳ��ʾ������
		map.put("size",pageSize);
		List<User> list = mapper.findUserListByPage(map);
		//4������
		for (User user : list) {
			System.out.println(user.getUserCode()+","+user.getUserName()+","+user.getUserRole());
		}
	}
	
	@Test
	public void test8() {
		//1.��ȡsession
		SqlSession session = MyBatisUtil.createSqlSession();
		//2.��������
		UserMapper mapper = session.getMapper(UserMapper.class);
		//3.����map���ϱ�����������
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("userCode", "a");
		map.put("userName", "��");
		map.put("gender", 2);
		List<User> list = mapper.findUserListWithChoose(map);
		//4������
		for (User user : list) {
			System.out.println(user.getUserCode()+","+user.getUserName()+","+user.getUserRole());
		}
	}
}
	
	
