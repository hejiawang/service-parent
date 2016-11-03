package com.wang.serviceimp.dao.permission.write;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.param.permission.PermissionUserInfoParam;

/**
 * 
 * 用户信息writer dao
 * 
 * @author HeJiawang
 * @date   2016.10.25
 *
 */
@MyBatisRepository
public interface PermissionUserInfoWriteDao {

	/**
	 * 新增用户信息
	 * @param userInfo 用户信息
	 * @author HeJiawang
	 * @date   2016.10.25
	 */
	Integer addUserInfo(PermissionUserInfoParam userInfo);

	/**
	 * 向用户机构关联表中插入数据
	 * @param userID 用户ID
	 * @param orgID 机构ID
	 * @author HeJiawang
	 * @date   2016.10.25
	 */
	Integer addUserOrg(@Param("userID") Integer userID, @Param("orgID") String orgID);

	/**
	 * 向用户岗位关联表中插入数据
	 * @param userID 用户ID
	 * @param postID 岗位ID
	 * @author HeJiawang
	 * @date   2016.10.25
	 */
	Integer addUserPost(@Param("userID") Integer userID, @Param("postID") String postID);

	/**
	 * 向用户职级关联表中插入数据
	 * @param userID 用户ID
	 * @param rankID 职级ID
	 * @author HeJiawang
	 * @date   2016.10.25
	 */
	Integer addUserRank(@Param("userID") Integer userID, @Param("rankID") String rankID);

	/**
	 * 向用户角色关联表中插入数据
	 * @param userID 用户ID
	 * @param roleID 角色ID
	 * @author HeJiawang
	 * @date   2016.10.25
	 */
	Integer addUserRole(@Param("userID") Integer userID, @Param("roleID") String roleID);

	/**
	 * 向用户系统关联表中插入数据
	 * @param userID 用户ID
	 * @param appID 系统ID
	 * @param appTypeID 系统类型ID 
	 * @author HeJiawang
	 * @date   2016.10.25
	 */
	Integer addUserApp(@Param("userID") Integer userID, @Param("appID") Integer appID,
			@Param("appTypeID") Integer appTypeID);

	/**
	 * 删除用户
	 * @param userID 用户ID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.11.02
	 */
	Integer deleteUserByID(@Param("userID") Integer userID);

	/**
	 * 修改用户信息
	 * @param userInfo 用户信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.11.03
	 */
	Integer updateUserInfo(PermissionUserInfoParam userInfo);
	
	/**
	 * 删除用户角色关联关系
	 * @param userID 用户ID
	 * @return
	 * @author HeJiawang
	 * @date   2016.11.03
	 */
	Integer deleteUserRole(@Param("userID") Integer userID);

	/**
	 * 删除用户岗位关联关系
	 * @param userID 用户ID
	 * @return
	 * @author HeJiawang
	 * @date   2016.11.03
	 */
	Integer deleteUserPost(@Param("userID") Integer userID);

	/**
	 * 删除用户职级关联关系
	 * @param userID 用户ID
	 * @return
	 * @author HeJiawang
	 * @date   2016.11.03
	 */
	Integer deleteUserRank(@Param("userID") Integer userID);

	/**
	 * 删除用户机构关联关系
	 * @param userID 用户ID
	 * @return
	 * @author HeJiawang
	 * @date   2016.11.03
	 */
	Integer deleteUserOrg(@Param("userID") Integer userID);

}
