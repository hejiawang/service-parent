package com.wang.serviceimp.dao.permission.read;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.param.permission.PermissionPostParam;

/**
 * 
 * 岗位read dao
 * 
 * @author HeJiawang
 * @date   2016.10.12
 *
 */
@MyBatisRepository
public interface PermissionPostReadDao {

	/**
	 * 获取分页岗位
	 * @param post  岗位参数
	 * @return     岗位集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	List<Map<String, Object>> getPageList(PermissionPostParam post);

	/**
	 * 查看岗位
	 * @param postID 岗位ID
	 * @return 岗位信息
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	Map<String, Object> getPostByID(@Param("postID") Integer postID);

	/**
	 * 检查岗位名称是否重复
	 * @param post 岗位信息
	 * @return True	重复
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	Integer checkExistPostName(PermissionPostParam post);

	/**
	 * 获取分页条数
	 * @param post  岗位参数
	 * @return     岗位集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	Integer getPageTotal(PermissionPostParam post);

	/**
	 * 获取岗位树</br>
	 * 即、全部岗位
	 * @return 岗位树
	 * @author HeJiawang
	 * @date   2016.11.02
	 */
	List<PermissionPostParam> queryPostForTree();

	/**
	 * 检查在用户岗位关联表中是否被引用
	 * @param postID 岗位ID
	 * @return >= 1 被引用
	 * @author HeJiawang
	 * @date   2016.11.04
	 */
	Integer checkPostFromUserPost(@Param("postID")Integer postID);

}
