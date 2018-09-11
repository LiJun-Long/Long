package com.llj.ssm.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.llj.ssm.dao.user.BillMapper;
import com.llj.ssm.dao.user.RoleMapper;
import com.llj.ssm.entity.Bill;
import com.llj.ssm.entity.Role;
import com.llj.ssm.util.MyBatisUtil;

public class JDT {
	private Logger logger=Logger.getLogger(JDT.class);
	/**
	 * 修改数据的方法
	 */
	@Test
	public void testUpdate() {
		logger.debug("修改一条信息==================");
		SqlSession sqlSession = null;
		int count=0;
		
		try {
			Bill bill=new Bill();
			bill.setId(18);
			bill.setIsPayment(2);
			bill.setModifyBy(1);
			bill.setModifyDate(new Date());
			//3 创建sqlSession
			sqlSession = MyBatisUtil.createSqlSession();
			//4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			count  = sqlSession.getMapper(BillMapper.class).update(bill);
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
	 * 简答题
	 */
	@Test
	public void testUpdateByID() {
		logger.debug("修改一条信息==================");
		SqlSession sqlSession = null;
		int count=0;
		try {
			Role role=new Role();
			role.setId(2);
			role.setRoleName("经理11");
			role.setModifyBy(1);
			role.setModifyDate(new Date());
			//3 创建sqlSession
			sqlSession = MyBatisUtil.createSqlSession();
			//4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			count  = sqlSession.getMapper(RoleMapper.class).update(role);
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
	 * 简答题
	 */
	@Test
	public void listinfo_FYBi() {
		SqlSession session=null;
		List<Role> list=new ArrayList<Role>();
		String roleName="员";
		Integer from =0;
		Integer pageSize=5;
		try {
			session = MyBatisUtil.createSqlSession();
			list = session.getMapper(RoleMapper.class).listinfo_FY(roleName,from, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(session);
		}
		for (Role role : list) {
			logger.debug("角色编码："+role.getRoleCode()+",角色名称："+role.getRoleName()
			+",创建者："+role.getCreatedBy()+",创建时间:"+role.getCreationDate());
		}
	}
}
