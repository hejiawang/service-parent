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
	Integer checkRankFromParentRank(Integer rankID);

	/**
	 * 查看职级
	 * @param rankID 职级ID
	 * @return 职级信息
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	Map<String, Object> getRankByID(Integer rankID);

}
