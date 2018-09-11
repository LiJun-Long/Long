package com.llj.ssm.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.llj.ssm.dao.user.UserMapper;
import com.llj.ssm.entity.User;
import com.llj.ssm.util.MyBatisUtil;

public class Sl {
	private Logger logger = Logger.getLogger(Sl.class);
	/**
	 * 示例3
	 */
	@Test
	public void slGetUserList() {
		SqlSession session = null;
		List<User> list = new ArrayList<User>();
		String userName = null;
		Integer roleId=null;
		try {
			session = MyBatisUtil.createSqlSession();
			list = session.getMapper(UserMapper.class).getUserList(userName, roleId);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(session);
		}
		for (User user : list) {
			logger.debug("slGetUserList===>id:" + user.getId()+",userCode:"+user.getUserCode()
			+",UserName:"+user.getUserName()+",UserRole:"+user.getUserRole()+",UserRoleName:"+user.getUserRoleName()
			+",Age:"+user.getAge()+",Phone:"+user.getPhone()+",Gender:"+user.getGender());
		}
	}
	/**
	 * 修改数据的方法
	 */
	@Test
	public void testUpdate() {
		logger.debug("修改一条信息==================");
		SqlSession sqlSession = null;
		int count=0;
		try {
			User user=new User();
			user.setId(18);
			user.setUserCode("testmodify");
			user.setUserName("李四");
			user.setUserPassword("8888888");
			//3 创建sqlSession
			sqlSession = MyBatisUtil.createSqlSession();
			//4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			count  = sqlSession.getMapper(UserMapper.class).update(user);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			count=0;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		logger.debug("影响行数为:"+count);
	}
	
	/**
	 * 示例11
	 */
	@Test
	public void slgetUserListByArray() {
		SqlSession session = null;
		List<User> list = new ArrayList<User>();
		Integer[] roleIds= {2,3};
		try {
			session = MyBatisUtil.createSqlSession();
			list = session.getMapper(UserMapper.class).getUserListByArray(roleIds);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(session);
		}
		for (User user : list) {
			logger.debug("slGetUserList===>id:" + user.getId()+",userCode:"+user.getUserCode()
			+",UserName:"+user.getUserName()+",UserRole:"+user.getUserRole());
		}
	}
	
	
	@Test
	public void slgetUserListByList() {
		SqlSession session = null;
		List<User> list = new ArrayList<User>();
		List<Integer> roleIdList = new ArrayList<Integer>();
		roleIdList.add(2);
		roleIdList.add(3);
		try {
			session = MyBatisUtil.createSqlSession();
			list = session.getMapper(UserMapper.class).getUserListByList(roleIdList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(session);
		}
		for (User user : list) {
			logger.debug("slGetUserList===>id:" + user.getId()+",userCode:"+user.getUserCode()
			+",UserName:"+user.getUserName()+",UserRole:"+user.getUserRole());
		}
	}
	
	@Test
	public void slgetUserListByMap() {
		SqlSession session = null;
		List<User> list = new ArrayList<User>();
		List<Integer> roleIdList = new ArrayList<Integer>();
		roleIdList.add(2);
		roleIdList.add(3);
		Map<String , Object> roleIdMap=new HashMap<String , Object>();
		roleIdMap.put("roleIds", roleIdList);
		roleIdMap.put("gender", 1);
		try {
			session = MyBatisUtil.createSqlSession();
			list = session.getMapper(UserMapper.class).getUserListByMap(roleIdMap);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(session);
		}
		for (User user : list) {
			logger.debug("slGetUserList===>id:" + user.getId()+",userCode:"+user.getUserCode()
			+",UserName:"+user.getUserName()+",UserRole:"+user.getUserRole());
		}
	}
	@Test
	public void slgetUserListByMaps() {
		SqlSession session = null;
		List<User> list = new ArrayList<User>();
		List<Integer> roleIdList = new ArrayList<Integer>();
		roleIdList.add(2);
		roleIdList.add(3);
		Map<String , Object> roleIdMap=new HashMap<String , Object>();
		roleIdMap.put("roleIds", roleIdList);
		try {
			session = MyBatisUtil.createSqlSession();
			list = session.getMapper(UserMapper.class).getUserListByMaps(roleIdMap);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(session);
		}
		for (User user : list) {
			logger.debug("slGetUserList===>id:" + user.getId()+",userCode:"+user.getUserCode()
			+",UserName:"+user.getUserName()+",UserRole:"+user.getUserRole());
		}
	}
	
	@Test
	public void slgetUserList_choose() {
		SqlSession session = null;
		List<User> list = new ArrayList<User>();
		String userName="张";
		Integer roleId=null;
		String userCode="";
		Date creationDate=null;
		try {
			creationDate = new SimpleDateFormat("yyyy-MM-dd").parse("2016-01-01");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
			session = MyBatisUtil.createSqlSession();
			list = session.getMapper(UserMapper.class).getUserList_choose(userName, roleId, userCode, creationDate);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(session);
		}
		for (User user : list) {
			logger.debug("slGetUserList===>id:" + user.getId()+",userCode:"+user.getUserCode()
			+",UserName:"+user.getUserName()+",UserRole:"+user.getUserRole());
		}
	}
	
	/**
	 * 示例22
	 */
	@Test
	public void slgetUserList_FY() {
		SqlSession session = null;
		List<User> list = new ArrayList<User>();
		String userName="";
		Integer roleId=null;
		Integer currentPageNo=1; //当前页
		Integer pageSize=5;		 //每页展示数据条数	
		Integer index=(currentPageNo-1)*pageSize; //查询起始位置
		try {
			session = MyBatisUtil.createSqlSession();
			list = session.getMapper(UserMapper.class).getUserList_FY(userName, roleId, index, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(session);
		}
		for (User user : list) {
			logger.debug("slGetUserList===>id:" + user.getId()
			+",userCode:"+user.getUserCode()
			+",UserName:"+user.getUserName()
			+",UserRole:"+user.getUserRole()
			+",UserRoleName:"+user.getUserRoleName()
			+",Age:"+user.getAge()
			+",Phone:"+user.getPhone()
			+",Gender:"+user.getGender()
			+",creationDate:"+new SimpleDateFormat("yyyy-MM-dd").format(user.getCreationDate()));
		}
	}
}
