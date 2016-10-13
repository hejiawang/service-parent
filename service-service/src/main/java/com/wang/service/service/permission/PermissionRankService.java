package com.wang.service.service.permission;

import java.util.List;
import java.util.Map;

import com.wang.core.ServiceResult;
import com.wang.service.param.permission.PermissionRankParam;

/**
 * 职级service
 * @author HeJiawang
 * @date   2016.10.13
 */
public interface PermissionRankService {

	/**
	 * 获取分页职级
	 * @param rank 职级参数
	 * @return 职级集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	ServiceResult<Map<String, Object>> pageRank(PermissionRankParam rank);

	/**
	 * 根据父职级ID获取职级树
	 * @param id	父职级ID
	 * @return		职级树
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	ServiceResult<List<PermissionRankParam>> findRankForTree(Integer parentRankID);
	
	/**
	 * 查看职级
	 * @param rankID 职级ID
	 * @return 职级信息
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	ServiceResult<Map<String, Object>> getRankByID(Integer rankID);

	/**
	 * 删除职级
	 * @param rankID 职级ID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	ServiceResult<Void> deleteRankByID(Integer rankID);

}
