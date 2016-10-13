package com.wang.serviceimp.dao.permission.write;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.param.permission.PermissionPostParam;

/**
 * 
 * 岗位writer dao
 * 
 * @author HeJiawang
 * @date   2016.10.12
 *
 */
@MyBatisRepository
public interface PermissionPostWriteDao {

	/**
	 * 删除岗位
	 * @param postID 岗位ID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	Integer deletePostByID(@Param("postID")Integer postID);

	/**
	 * 新增岗位
	 * @param post 岗位信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	void addPost(PermissionPostParam post);

}
