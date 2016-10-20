package com.wang.serviceimp.dao.permission.read;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.param.permission.PermissionRankParam;

/**
 * 
 * 职级read dao
 * 
 * @author HeJiawang
 * @date   2016.10.13
 *
 */
@MyBatisRepository
public interface PermissionRankReadDao {

	/**
	 * 获取分页职级
	 * @param rank 职级参数
	 * @return 职级集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	List<Map<String, Object>> getPageList(PermissionRankParam rank);

	/**
	 * 根据父职级ID获取职级树
	 * @param id	父职级ID
	 * @return		职级树
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	List<PermissionRankParam> findRankForTree( @Param("parentRankID") Integer parentRankID);

	/**
	 * 检查职级是否被引用
	 * @param rankID 职级ID
	 * @return 是否被引用: true--引用
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	Integer checkRankFromParentRank(@Param("rankID") Integer rankID);

	/**
	 * 在同一父职级下，检查职级名称是否重复
	 * @param rank		职级
	 * @return 职级名称是否重复——true:重复
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	Integer checkExistRankName(PermissionRankParam rank);
	
	/**
	 * 查看职级
	 * @param rankID 职级ID
	 * @return 职级信息
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	Map<String, Object> getRankByID(@Param("rankID") Integer rankID);

	/**
	 * 获取分页职级
	 * @param rank 职级参数
	 * @return 职级集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	Integer getPageTotal(PermissionRankParam rank);

}
