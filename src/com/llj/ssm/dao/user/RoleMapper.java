package com.llj.ssm.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.llj.ssm.entity.Role;

public interface RoleMapper {
	/**
	 * 修改信息
	 * @param role
	 * @return
	 */
	int update(Role role);
	
	List<Role> showInfoByrName(String roleName);
	
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
	List<Role> listinfo_FY( @Param("roleName") String roleName,
							@Param("from") Integer currentPageNo,
							@Param("pageSize") Integer pageSize );
}
