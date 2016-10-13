package com.wang.serviceimp.dao.permission.write;

import com.wang.core.repository.myBatis.MyBatisRepository;

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
	Integer deleteRankByID(Integer rankID);

}
