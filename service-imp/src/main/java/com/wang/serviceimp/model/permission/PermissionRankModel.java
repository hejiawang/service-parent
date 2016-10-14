package com.wang.serviceimp.model.permission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.core.util.WebConstants;
import com.wang.service.param.permission.PermissionRankParam;
import com.wang.serviceimp.dao.permission.read.PermissionRankReadDao;
import com.wang.serviceimp.dao.permission.write.PermissionRankWriteDao;

/**
 * 职级model
 * 
 * @author HeJiawang
 * @date   2016.10.13
 */
@Service
public class PermissionRankModel {
	
	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionRankModel.class);
	
	/**
	 * permissionPostReadDao
	 */
	@Autowired
	private PermissionRankReadDao permissionRankReadDao;
	
	/**
	 * permissionPostWriteDao
	 */
	@Autowired
	private PermissionRankWriteDao permissionRankWriteDao;

	/**
	 * 获取分页职级
	 * @param rank 职级参数
	 * @return 职级集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	public Map<String, Object> pageRank(PermissionRankParam rank) {
		Assert.notNull(permissionRankReadDao, "Property 'permissionRankReadDao' is required.");
		if( rank.getPageSize() == null || rank.getPageNumber() == null || rank.getDraw() == null ) 
			throw new BusinessException("分页信息不能为空");
		
		//初始页面取跟节点
		if(rank.getRankID() == null){
			rank.setRankID(WebConstants.OrgRootID);
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<Map<String,Object>> pageLsit = permissionRankReadDao.getPageList(rank);
		Integer recordsTotal = pageLsit.size();
		
		map.put("draw", rank.getDraw());
		map.put("data", pageLsit);
		map.put("recordsTotal", recordsTotal);
		map.put("recordsFiltered",  recordsTotal);
		
		return map;
	}

	/**
	 * 根据父职级ID获取职级树
	 * @param id	父职级ID
	 * @return		职级树
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	public List<PermissionRankParam> findRankForTree(Integer parentRankID) {
		Assert.notNull(permissionRankReadDao, "Property 'permissionRankReadDao' is required.");
		if( parentRankID == null ) throw new BusinessException("职级父ID不能为空");
		
		return permissionRankReadDao.findRankForTree(parentRankID);
	}


	/**
	 * 检查职级是否被引用
	 * @param rankID 职级ID
	 * @return 是否被引用: true--引用
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	public Boolean checkRankByID(Integer rankID) {
		Assert.notNull(permissionRankReadDao, "Property 'permissionRankReadDao' is required.");
		if( rankID == null ) throw new BusinessException("机构ID不能为空");
		
		Integer checkResult = permissionRankReadDao.checkRankFromParentRank(rankID);	//检查是否被当做父机构引用
		if( checkResult >= 1 ){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 在同一父职级下，检查职级名称是否重复
	 * @param rank		职级
	 * @return 职级名称是否重复——true:重复
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	public Boolean checkExistRankName(PermissionRankParam rank) {
		Assert.notNull(permissionRankReadDao, "Property 'permissionRankReadDao' is required.");
		if( rank == null ) throw new BusinessException("职级不能为空");
		if( rank.getParentRankID() == null  ) throw new BusinessException("职级父ID不能为空");
		
		Integer checkResult = permissionRankReadDao.checkExistRankName(rank);
		if( checkResult >= 1 ){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 查看职级
	 * @param rankID 职级ID
	 * @return 职级信息
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	public Map<String, Object> getRankByID(Integer rankID) {
		Assert.notNull(permissionRankReadDao, "Property 'permissionRankReadDao' is required.");
		if( rankID == null ) throw new BusinessException("职级ID不能为空");
		
		return permissionRankReadDao.getRankByID(rankID);
	}

	/**
	 * 删除职级
	 * @param rankID 职级ID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	public Boolean deleteRankByID(Integer rankID) {
		Assert.notNull(permissionRankWriteDao, "Property 'permissionOrgWriteDao' is required.");
		if( rankID == null ) throw new BusinessException("职级ID不能为空");
		if( rankID == 1001 ) throw new BusinessException("跟职级不可删除");
		
		Integer deleteResult = permissionRankWriteDao.deleteRankByID(rankID);
		if( deleteResult >= 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 新增职级
	 * @param rank 职级信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	public void addRank(PermissionRankParam rank) {
		Assert.notNull(permissionRankWriteDao, "Property 'permissionRankWriteDao' is required.");
		if( rank == null ) throw new BusinessException("职级不能为空");
		
		permissionRankWriteDao.addRank(rank);
	}

	/**
	 * 修改职级
	 * @param  rank	职级信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	public Boolean updateRank(PermissionRankParam rank) {
		Assert.notNull(permissionRankWriteDao, "Property 'permissionRankWriteDao' is required.");
		if( rank == null ) throw new BusinessException("职级不能为空");
		if( rank.getRankID() == 1001 ) throw new BusinessException("跟职级不可修改");
		
		Integer updateResult = permissionRankWriteDao.updateRank(rank);
		if( updateResult >= 1 ){
			return true;
		} else {
			return false;
		}
	}

}
