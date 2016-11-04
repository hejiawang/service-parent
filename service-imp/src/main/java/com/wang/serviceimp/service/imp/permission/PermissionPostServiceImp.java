package com.wang.serviceimp.service.imp.permission;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.Constants;
import com.wang.core.ServiceResult;
import com.wang.core.exception.BusinessException;
import com.wang.service.param.permission.PermissionPostParam;
import com.wang.service.service.permission.PermissionPostService;
import com.wang.serviceimp.model.permission.PermissionPostModel;

/**
 * 岗位service imp
 * 
 * @author HeJiawang
 * @date   2016.10.12
 */
@Service
public class PermissionPostServiceImp implements PermissionPostService {

	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionPostServiceImp.class);
	
	/**
	 * permissionpostModel
	 */
	@Autowired
	private PermissionPostModel permissionpostModel;

	/**
	 * 获取分页岗位
	 * @param post  岗位参数
	 * @return     岗位集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	@Override
	public ServiceResult<Map<String, Object>> pagePost(PermissionPostParam post) {
		Assert.notNull(permissionpostModel, "Property 'permissionpostModel' is required.");
		ServiceResult<Map<String, Object>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionpostModel.pagePost(post));
		} catch (BusinessException e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setSuccess(false);
		} catch (Exception e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setError(Constants.SERVICE_RESULT_CODE_SYS_ERROR, Constants.SERVICE_RESULT_EXCEPTION_SYS_ERROR);
			logger.error("发生未知异常!", e);
		}
		return serviceResult;
	}

	/**
	 * 查看岗位
	 * @param postID 岗位ID
	 * @return 岗位信息
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	@Override
	public ServiceResult<Map<String, Object>> getPostByID(Integer postID) {
		Assert.notNull(permissionpostModel, "Property 'permissionpostModel' is required.");
		ServiceResult<Map<String, Object>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionpostModel.getPostByID(postID));
		} catch (BusinessException e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setSuccess(false);
		} catch (Exception e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setError(Constants.SERVICE_RESULT_CODE_SYS_ERROR, Constants.SERVICE_RESULT_EXCEPTION_SYS_ERROR);
			logger.error("发生未知异常!", e);
		}
		return serviceResult;
	}

	/**
	 * 删除岗位
	 * @param postID 岗位ID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	@Override
	public ServiceResult<Void> deletePostByID(Integer postID) {
		Assert.notNull(permissionpostModel, "Property 'permissionpostModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			Boolean checkResult = permissionpostModel.checkPostByID(postID);
			if( checkResult ){
				serviceResult.setSuccess(false);
				serviceResult.setMessage("该岗位信息被引用,不可删除");
			} else {
				Boolean deleteResult = permissionpostModel.deletePostByID(postID);
				if( deleteResult ){
					serviceResult.setMessage("删除岗位成功");
				}else{
					serviceResult.setMessage("删除岗位失败");
				}
				serviceResult.setSuccess(deleteResult);
			}
		} catch (BusinessException e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setSuccess(false);
		} catch (Exception e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setError(Constants.SERVICE_RESULT_CODE_SYS_ERROR, Constants.SERVICE_RESULT_EXCEPTION_SYS_ERROR);
			logger.error("发生未知异常!", e);
		}
		return serviceResult;
	}

	/**
	 * 新增岗位
	 * @param post 岗位信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	@Override
	public ServiceResult<Void> addPost(PermissionPostParam post) {
		Assert.notNull(permissionpostModel, "Property 'permissionpostModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			Boolean existName = permissionpostModel.checkExistPostName(post);	//检查岗位名称是否重复
			if(existName){
				serviceResult.setSuccess(false);
				serviceResult.setMessage("岗位编码重复,新增岗位失败");
			} else {
				permissionpostModel.addPost(post);
				serviceResult.setSuccess(true);
				serviceResult.setMessage("新增岗位成功");
			}
		} catch (BusinessException e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setSuccess(false);
		} catch (Exception e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setError(Constants.SERVICE_RESULT_CODE_SYS_ERROR, Constants.SERVICE_RESULT_EXCEPTION_SYS_ERROR);
			logger.error("发生未知异常!", e);
		}
		return serviceResult;
	}

	/**
	 * 修改岗位
	 * @param post 岗位信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	@Override
	public ServiceResult<Void> updatePost(PermissionPostParam post) {
		Assert.notNull(permissionpostModel, "Property 'permissionpostModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			Boolean existName = permissionpostModel.checkExistPostName(post);	//检查岗位名称是否重复
			if(existName){
				serviceResult.setSuccess(false);
				serviceResult.setMessage("岗位编码重复,新增岗位失败");
			} else {
				permissionpostModel.updatePost(post);
				serviceResult.setSuccess(true);
				serviceResult.setMessage("新增岗位成功");
			}
		} catch (BusinessException e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setSuccess(false);
		} catch (Exception e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setError(Constants.SERVICE_RESULT_CODE_SYS_ERROR, Constants.SERVICE_RESULT_EXCEPTION_SYS_ERROR);
			logger.error("发生未知异常!", e);
		}
		return serviceResult;
	}


	/**
	 * 获取岗位树</br>
	 * 即、全部岗位
	 * @return 岗位树
	 * @author HeJiawang
	 * @date   2016.11.02
	 */
	@Override
	public ServiceResult<List<PermissionPostParam>> queryPostForTree() {
		Assert.notNull(permissionpostModel, "Property 'permissionpostModel' is required.");
		ServiceResult<List<PermissionPostParam>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionpostModel.queryPostForTree());
		} catch (BusinessException e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setSuccess(false);
		} catch (Exception e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setError(Constants.SERVICE_RESULT_CODE_SYS_ERROR, Constants.SERVICE_RESULT_EXCEPTION_SYS_ERROR);
			logger.error("发生未知异常!", e);
		}
		return serviceResult;
	}
}
