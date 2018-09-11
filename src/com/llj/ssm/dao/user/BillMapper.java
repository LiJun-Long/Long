package com.llj.ssm.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.llj.ssm.entity.Bill;

public interface BillMapper {
	/**
	 * 多条件查询
	 * @param bill
	 * @return
	 */
	List<Bill> listinfo(@Param("productName") String productName,@Param("providerId")Integer providerId, @Param("isPayment") Integer isPayment );
	/**
	 * 多条件查询
	 * @param bill
	 * @return
	 */
	List<Bill> listinfo1(Bill bill);
	
	/**
	 * 获取总记录数方法
	 * @return
	 */
	public int count();
	/**
	 * 上机练习8
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	List<Bill> listinfo_FY( @Param("from") Integer currentPageNo,
			@Param("pageSize") Integer pageSize );
	/**
	 * 简答题
	 * @param id
	 * @return
	 */
	public int update(Bill bill);
}
