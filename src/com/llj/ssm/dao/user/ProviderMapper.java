package com.llj.ssm.dao.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.llj.ssm.entity.Provider;

public interface ProviderMapper {
	
	List<Provider> listinfoByPid(Integer pId);
	
	List<Provider> listInfoByNameORCode(@Param("code") String code,@Param("name") String name);
	/**
	 * 上机练习3
	 * 修改信息
	 * @param provider
	 * @return
	 */
	int update(Provider provider);
	/**
	 * 上机练习5数组方式入参
	 * @param proIds
	 * @return
	 */
	List<Provider> listinfo_Array(Integer[] proIds);
	/**
	 * 上机练习5集合方式入参
	 * @param proIds
	 * @return
	 */
	List<Provider> listinfo_List(List<Integer> proIds);
	
	/**
	 * 上机练习6
	 * @param proMap
	 * @return
	 */
	List<Provider> listinfo_Map(Map<String , Object> proMap);
	/**
	 * 上机练习7
	 * @param provider
	 * @return
	 */
	List<Provider> listinfo_choose(Provider provider);
	
	/**
	 * 获取总记录数方法
	 * @return
	 */
	public int count();
	
	List<Provider> listinfo_FY( @Param("from") Integer currentPageNo,
								@Param("pageSize") Integer pageSize );
	
}	
