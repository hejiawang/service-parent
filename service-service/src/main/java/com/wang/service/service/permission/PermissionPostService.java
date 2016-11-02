package com.wang.service.service.permission;

import java.util.List;
import java.util.Map;

import com.wang.core.ServiceResult;
import com.wang.service.param.permission.PermissionPostParam;

/**
 * 岗位service
 * @author HeJiawang
 * @date   2016.10.12
 */
public interface PermissionPostService {

	/**
	 * 获取分页岗位
	 * @param post  岗位参数
	 * @return     岗位集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	ServiceResult<Map<String, Object>> pagePost(PermissionPostParam post);

	/**
	 * 查看岗位
	 * @param postID 岗位ID
	 * @return 岗位信息
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	ServiceResult<Map<String, Object>> getPostByID(Integer postID);

	/**
	 * 删除岗位
	 * @param postID 岗位ID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	ServiceResult<Void> deletePostByID(Integer postID);

	/**
	 * 新增岗位
	 * @param post 岗位信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	ServiceResult<Void> addPost(PermissionPostParam post);

	/**
	 * 修改岗位
	 * @param post 岗位信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	ServiceResult<Void> updatePost(PermissionPostParam post);

	/**
	 * 获取岗位树</br>
	 * 即、全部岗位
	 * @return 岗位树
	 * @author HeJiawang
	 * @date   2016.11.02
	 */
	ServiceResult<List<PermissionPostParam>> queryPostForTree();

}
