package com.wang.serviceimp.dao.permission.write;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.param.permission.PermissionRankParam;

/**
 * 
 * 职级writer dao
 * 
 * @author HeJiawang
 * @date   2016.10.13
 *
 */
@MyBatisRepository
public interface PermissionRankWriteDao {

	/**
	 * 删除职级
	 * @param rankID 职级ID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	Integer deleteRankByID(@Param("rankID") Integer rankID);

	/**
	 * 新增职级
	 * @param rank 职级信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	void addRank(PermissionRankParam rank);

	/**
	 * 修改职级
	 * @param  rank	职级信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	Integer updateRank(PermissionRankParam rank);

}
