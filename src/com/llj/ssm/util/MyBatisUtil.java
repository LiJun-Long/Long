package com.llj.ssm.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 工具类
 * @author 
 *
 */
public class MyBatisUtil {
	
	private static SqlSessionFactory factory;
	
	static{
		
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		
			 factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 创建一个SqlSession 对象
	 * @return
	 */
	public static SqlSession createSqlSession(){
	
		//openSession(true/false) 当为true时为关闭事务控制，自动提交事务，false为开启事务控制
	 return	factory.openSession(false);
	}
	
	/**
	 * 关闭SqlSession对象
	 * @param sqlSession
	 */
	public static void closeSqlSession(SqlSession sqlSession){
		
		if(sqlSession != null){
			
			sqlSession.close();
		}
		
	}
}
