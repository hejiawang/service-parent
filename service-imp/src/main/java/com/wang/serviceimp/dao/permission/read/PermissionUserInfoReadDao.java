package com.wang.serviceimp.dao.permission.read;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.param.permission.PermissionUserInfoParam;

/**
 * 
 * 用户信息read dao
 * 
 * @author HeJiawang
 * @date   2016.10.25
 *
 */
@MyBatisRepository
public interface PermissionUserInfoReadDao {

	/**
	 * 获取分页用户信息
	 * @param userInfo 用户信息
	 * @return 分页数据
	 */
	List<Map<String, Object>> getPageList(PermissionUserInfoParam userInfo);

	/**
	 * 获取用户信息条数
	 * @param userInfo 用户信息
	 * @return 用户信息条数
	 */
	Integer getPageTotal(PermissionUserInfoParam userInfo);
	
	/**
	 * 检查用户登录名时候重复
	 * @param userInfo 用户信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.25
	 */
	Integer checkExistUserLoginName(PermissionUserInfoParam userInfo);

	/**
	 * 根据用户ID获取该用户角色ID集合
	 * @param userID 用户ID
	 * @return 角色ID集合
	 * @author HeJiawang
	 * @date   2016.10.25
	 */
	List<Integer> getRoleIDListByUserID(@Param("userID")Integer userID);

	/**
	 * 根据用户ID获取该用户所在机构ID
	 * @param userID 用户ID
	 * @return 机构ID
	 * @author HeJiawang
	 * @date   2016.11.03
	 */
	Integer getOrgIDByUserID(@Param("userID")Integer userID);
	
	/**
	 * 查看用户信息
	 * @param userInfoID 用户ID
	 * @return 用户信息
	 * @author HeJiawang
	 * @date   2016.11.03
	 */
	PermissionUserInfoParam getUserInfoByID(@Param("userID")Integer userID);

	/**
	 * 获取当前登录账号所属部门下的所有用户信息
	 * @param paramMap 参数Map,key:userInfo、org
	 * @return 分页用户信息
	 * @author HeJiawang
	 * @date   2016.11.03
	 */
	List<Map<String, Object>> getPagePartList(Map<String, Object> paramMap);

	/**
	 * 获取当前登录账号所属部门下的所有用户信息条数
	 * @param paramMap 参数Map
	 * @return 分页用户信息条数
	 * @author HeJiawang
	 * @date   2016.11.03
	 */
	Integer getPagePartTotal(Map<String, Object> paramMap);

}
