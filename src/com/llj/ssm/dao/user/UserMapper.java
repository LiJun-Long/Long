package com.llj.ssm.dao.user;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.llj.ssm.entity.User;

public interface UserMapper {
	/**
	 * 示例1 查询用户列表
	 * 
	 * @param userName
	 * @param roleId
	 * @return
	 */
	List<User> getUserList(@Param("userName") String userName, @Param("userRole") Integer roleId);

	/**
	 * 修改数据的方法
	 * 
	 * @param user
	 * @return
	 */
	int update(User user);

	/**
	 * 示例9
	 * 
	 * @param rolesId
	 * @return
	 */
	List<User> getUserListByArray(Integer[] roleIds);

	/**
	 * 示例12
	 * 
	 * @param roleIdList
	 * @return
	 */
	List<User> getUserListByList(List<Integer> roleIdList);

	/**
	 * 示例14
	 * 
	 * @param roleIdMap
	 * @return
	 */
	List<User> getUserListByMap(Map<String, Object> roleIdMap);

	/**
	 * 示例16
	 * 
	 * @param roleIdMap
	 * @return
	 */
	List<User> getUserListByMaps(Map<String, Object> roleIdMap);
	/**
	 * 示例18
	 * @param userName
	 * @param userRole
	 * @param userCode
	 * @param creationDate
	 * @return
	 */
	List<User> getUserList_choose(@Param("userName") String userName,
								  @Param("userRole") Integer userRole,
								  @Param("userCode") String userCode,
								  @Param("creationDate") Date creationDate);
	/**
	 * 获取总记录数方法
	 * @return
	 */
	public int count();
	
	/**
	 * 查询用户列表（示例20）
	 * @param userName
	 * @param userRole
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	List<User> getUserList_FY(@Param("userName") String userName,
			  @Param("userRole") Integer userRole,
			  @Param("from") Integer currentPageNo,
			  @Param("pageSize") Integer pageSize);
}
