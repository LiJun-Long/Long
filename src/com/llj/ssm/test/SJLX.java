package com.llj.ssm.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.llj.ssm.dao.user.BillMapper;
import com.llj.ssm.dao.user.ProviderMapper;
import com.llj.ssm.entity.Bill;
import com.llj.ssm.entity.Provider;
import com.llj.ssm.util.MyBatisUtil;

public class SJLX {
	private Logger logger=Logger.getLogger(SJLX.class);
	/**
	 * 上机练习1
	 */
	@Test
	public void sjlxlistInfo() {
		SqlSession session=null;
		List<Bill> list=new ArrayList<Bill>();
		String ProductName="米";
		Integer ProviderId=null;
		Integer IsPayment=null;
		try {
			session = MyBatisUtil.createSqlSession();
			list = session.getMapper(BillMapper.class).listinfo(ProductName,ProviderId,IsPayment);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(session);
		}
		for (Bill bills : list) {
			logger.debug("订单编码："+bills.getBillCode()+"，商品名称："+bills.getProductName()
			+"，供应商名称："+bills.getProductName()+"，账单金额："+bills.getTotalPrice()
			+"，是否付款："+bills.getIsPayment()+"，创建时间："+bills.getCreationDate());
		}
	}
	@Test
	public void sjlxlistInfoByNameORCode() {
		SqlSession session=null;
		List<Provider> list=new ArrayList<Provider>();
		String code="G";
		String name=null;
		try {
			session = MyBatisUtil.createSqlSession();
			list = session.getMapper(ProviderMapper.class).listInfoByNameORCode(code, name);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(session);
		}
		for (Provider pro : list) {
			logger.debug("供应商id:"+pro.getId()+",供应商编码:"+pro.getProCode()
			+",供应商名称:"+pro.getProName()+",供应商联系人:"+pro.getProContact()+",供应商联系电话:"+pro.getProPhone()
			+",供应商传真:"+pro.getProFax()+",创建时间:"+pro.getCreationDate());
		}
	}
	/**
	 * 上机练习2
	 * 修改数据的方法
	 */
	@Test
	public void testUpdate() {
		logger.debug("修改一条信息==================");
		SqlSession sqlSession = null;
		int count=0;
		
		try {
			Provider provider=new Provider();
			provider.setId(17);
			provider.setProCode("测试数据88");
			provider.setProName("测试数据名称11");
			provider.setModifyBy(1);
			provider.setModifyDate(new Date());
			//3 创建sqlSession
			sqlSession = MyBatisUtil.createSqlSession();
			//4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			count  = sqlSession.getMapper(ProviderMapper.class).update(provider);
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
	 * 上机练习5
	 */
	@Test
	public void listinfo_Array() {
		SqlSession sqlSession = null;
		List<Provider> list=new ArrayList<Provider>();
		Integer [] proid= {8,10,12};
		try {
			//3 创建sqlSession
			sqlSession = MyBatisUtil.createSqlSession();
			//4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			list  = sqlSession.getMapper(ProviderMapper.class).listinfo_Array(proid);
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		for (Provider pro : list) {
			logger.debug("供应商id:"+pro.getId()+",供应商编码:"+pro.getProCode()
			+",供应商名称:"+pro.getProName()+",供应商联系人:"+pro.getProContact()+",供应商联系电话:"+pro.getProPhone()
			+",供应商传真:"+pro.getProFax()+",创建时间:"+pro.getCreationDate());
		}
	}
	/**
	 * 上机练习5
	 */
	@Test
	public void listinfo_List() {
		SqlSession sqlSession = null;
		List<Provider> list=new ArrayList<Provider>();
		List<Integer> proid=new ArrayList<Integer>();
		proid.add(8);
		proid.add(10);
		proid.add(12);
		try {
			//3 创建sqlSession
			sqlSession = MyBatisUtil.createSqlSession();
			//4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			list  = sqlSession.getMapper(ProviderMapper.class).listinfo_List(proid);
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		for (Provider pro : list) {
			logger.debug("供应商id:"+pro.getId()+",供应商编码:"+pro.getProCode()
			+",供应商名称:"+pro.getProName()+",供应商联系人:"+pro.getProContact()+",供应商联系电话:"+pro.getProPhone()
			+",供应商传真:"+pro.getProFax()+",创建时间:"+pro.getCreationDate());
		}
		
	}
	
	/**
	 * 上机练习6
	 */
	@Test
	public void listinfo_Map() {
		SqlSession sqlSession = null;
		List<Provider> list=new ArrayList<Provider>();
		List<Integer> proid=new ArrayList<Integer>();
		proid.add(8);
		proid.add(10);
		proid.add(12);
		Map<String , Object> proMap=new HashMap<String , Object>();
		proMap.put("proIds", proid);
		proMap.put("proCode", "1");
		try {
			//3 创建sqlSession
			sqlSession = MyBatisUtil.createSqlSession();
			//4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			list  = sqlSession.getMapper(ProviderMapper.class).listinfo_Map(proMap);
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		for (Provider pro : list) {
			logger.debug("供应商id:"+pro.getId()+",供应商编码:"+pro.getProCode()
			+",供应商名称:"+pro.getProName()+",供应商联系人:"+pro.getProContact()+",供应商联系电话:"+pro.getProPhone()
			+",供应商传真:"+pro.getProFax()+",创建时间:"+pro.getCreationDate());
		}
	}
	
	/**
	 * 上机练习7
	 */
	@Test
	public void listinfo_choose() {
		SqlSession sqlSession = null;
		List<Provider> list=new ArrayList<Provider>();
		Provider proMap=new Provider();
		proMap.setProName("测");
		proMap.setProCode("");
		proMap.setProContact("");
		proMap.setCreationDate(new Date());
		try {
			//3 创建sqlSession
			sqlSession = MyBatisUtil.createSqlSession();
			//4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			list  = sqlSession.getMapper(ProviderMapper.class).listinfo_choose(proMap);
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		for (Provider pro : list) {
			logger.debug("供应商id:"+pro.getId()+",供应商编码:"+pro.getProCode()
			+",供应商名称:"+pro.getProName()+",供应商联系人:"+pro.getProContact()+",供应商联系电话:"+pro.getProPhone()
			+",供应商传真:"+pro.getProFax()+",创建时间:"+pro.getCreationDate());
		}
	}
	
	/**
	 * 上机练习7
	 */
	@Test
	public void listinfo_FYPro() {
		SqlSession sqlSession = null;
		List<Provider> list=new ArrayList<Provider>();
		Integer from =0;
		Integer pageSize=5;
		try {
			//3 创建sqlSession
			sqlSession = MyBatisUtil.createSqlSession();
			//4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			list  = sqlSession.getMapper(ProviderMapper.class).listinfo_FY(from, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		for (Provider pro : list) {
			logger.debug("供应商id:"+pro.getId()+",供应商编码:"+pro.getProCode()
			+",供应商名称:"+pro.getProName()+",供应商联系人:"+pro.getProContact()
			+",供应商联系电话:"+pro.getProPhone());
		}
	}
	/**
	 * 上机练习8
	 */
	@Test
	public void listinfo_FYBi() {
		SqlSession session=null;
		List<Bill> list=new ArrayList<Bill>();
		Integer from =0;
		Integer pageSize=5;
		try {
			session = MyBatisUtil.createSqlSession();
			list = session.getMapper(BillMapper.class).listinfo_FY(from, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(session);
		}
		for (Bill bills : list) {
			logger.debug("订单编码："+bills.getBillCode()+"，商品名称："+bills.getProductName()
			+"，供应商名称："+bills.getProductName()+"，账单金额："+bills.getTotalPrice()
			+"，是否付款："+bills.getIsPayment());
		}
	}
}
