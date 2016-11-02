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
import com.wang.service.param.permission.PermissionPostParam;
import com.wang.serviceimp.dao.permission.read.PermissionPostReadDao;
import com.wang.serviceimp.dao.permission.write.PermissionPostWriteDao;

/**
 * 岗位 model
 * 
 * @author HeJiawang
 * @date   2016.10.12
 */
@Service
public class PermissionPostModel {

	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionPostModel.class);
	
	/**
	 * permissionPostReadDao
	 */
	@Autowired
	private PermissionPostReadDao permissionPostReadDao;
	
	/**
	 * permissionPostWriteDao
	 */
	@Autowired
	private PermissionPostWriteDao permissionPostWriteDao;

	/**
	 * 获取分页岗位
	 * @param post  岗位参数
	 * @return     岗位集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	public Map<String, Object> pagePost(PermissionPostParam post) {
		Assert.notNull(permissionPostReadDao, "Property 'permissionPostReadDao' is required.");
		if( post.getPageStart() == null || post.getPageEnd() == null || post.getDraw() == null ) 
			throw new BusinessException("分页信息不能为空");
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<Map<String,Object>> pageLsit = permissionPostReadDao.getPageList(post);
		Integer recordsTotal = permissionPostReadDao.getPageTotal(post);
		
		map.put("draw", post.getDraw());
		map.put("data", pageLsit);
		map.put("recordsTotal", recordsTotal);
		map.put("recordsFiltered",  recordsTotal);
		
		return map;
	}
	
	/**
	 * 查看岗位
	 * @param postID 岗位ID
	 * @return 岗位信息
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	public Map<String, Object> getPostByID(Integer postID) {
		Assert.notNull(permissionPostReadDao, "Property 'permissionPostReadDao' is required.");
		if( postID == null ) throw new BusinessException("岗位ID不能为空");
		
		return permissionPostReadDao.getPostByID(postID);
	}

	/**
	 * 删除岗位
	 * @param postID 岗位ID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	public Boolean deletePostByID(Integer postID) {
		Assert.notNull(permissionPostWriteDao, "Property 'permissionPostWriteDao' is required.");
		if( postID == null ) throw new BusinessException("岗位ID不能为空");
		
		Integer deleteResult = permissionPostWriteDao.deletePostByID(postID);
		if( deleteResult >= 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 检查岗位名称是否重复
	 * @param post 岗位信息
	 * @return True	重复
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	public Boolean checkExistPostName(PermissionPostParam post) {
		Assert.notNull(permissionPostReadDao, "Property 'permissionPostReadDao' is required.");
		if( post == null ) throw new BusinessException("岗位不能为空");
		
		Integer result = permissionPostReadDao.checkExistPostName(post);
		if( result >= 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 新增岗位
	 * @param post 岗位信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	public void addPost(PermissionPostParam post) {
		Assert.notNull(permissionPostWriteDao, "Property 'permissionPostWriteDao' is required.");
		if( post == null ) throw new BusinessException("岗位不能为空");
		
		permissionPostWriteDao.addPost(post);
	}

	/**
	 * 修改岗位
	 * @param post 岗位信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	public void updatePost(PermissionPostParam post) {
		Assert.notNull(permissionPostWriteDao, "Property 'permissionPostWriteDao' is required.");
		if( post == null ) throw new BusinessException("岗位不能为空");
		
		permissionPostWriteDao.updatePost(post);
	}

	/**
	 * 获取岗位树</br>
	 * 即、全部岗位
	 * @return 岗位树
	 * @author HeJiawang
	 * @date   2016.11.02
	 */
	public List<PermissionPostParam> queryPostForTree() {
		Assert.notNull(permissionPostReadDao, "Property 'permissionPostReadDao' is required.");
		
		return permissionPostReadDao.queryPostForTree();
	}
}
