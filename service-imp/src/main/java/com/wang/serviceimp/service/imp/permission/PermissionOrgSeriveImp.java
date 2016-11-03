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
import com.wang.service.param.permission.PermissionOrgParam;
import com.wang.service.service.permission.PermissionOrgService;
import com.wang.serviceimp.model.permission.PermissionOrgModel;

/**
 * 机构service imp
 * 
 * @author HeJiawang
 * @date   2016.10.10
 */
@Service
public class PermissionOrgSeriveImp implements PermissionOrgService {
	
	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionOrgSeriveImp.class);
	
	/**
	 * permissionOrgModel
	 */
	@Autowired
	private PermissionOrgModel permissionOrgModel;
	
	/**
	 * 获取分页机构
	 * @param org  机构参数
	 * @return     机构集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.10
	 */
	@Override
	public ServiceResult<Map<String, Object>> pageOrg(PermissionOrgParam org) {
		Assert.notNull(permissionOrgModel, "Property 'permissionOrgModel' is required.");
		ServiceResult<Map<String, Object>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionOrgModel.pageOrg(org));
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
	 * 根据机构ID获取机构信息
	 * @param orgID 机构ID
	 * @return 机构信息
	 * @author HeJiawang
	 * @date   2016.10.10
	 */
	@Override
	public ServiceResult<Map<String, Object>> getOrgByID(Integer orgID) {
		Assert.notNull(permissionOrgModel, "Property 'permissionOrgModel' is required.");
		ServiceResult<Map<String, Object>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionOrgModel.getOrgByID(orgID));
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
	 * 删除机构
	 * 根机构不可删除——orgID:1001
	 * @param orgID 机构ID
	 * @return 返回信息: ServiceResult.success true--删除成功
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	@Override
	public ServiceResult<Void> deleteOrgByID(Integer orgID) {
		Assert.notNull(permissionOrgModel, "Property 'permissionOrgModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			if( orgID == 1001 ){
				serviceResult.setSuccess(false);
				serviceResult.setMessage("机构树信息不可删除");
				return serviceResult;
			}
			
			Boolean checkResult = permissionOrgModel.checkOrgByID(orgID);
			if( checkResult ){
				serviceResult.setSuccess(false);
				serviceResult.setMessage("该机构信息被引用,不可删除");
			}else{
				Boolean deleteResult = permissionOrgModel.deleteOrgByID(orgID);
				if( deleteResult ){
					serviceResult.setMessage("删除机构成功");
				}else{
					serviceResult.setMessage("删除机构失败");
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
	 * 检查机构是否被引用
	 * @param orgID 机构ID
	 * @return 返回信息: ServiceResult.success true--引用
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	@Override
	public ServiceResult<Void> checkOrgByID(Integer orgID) {
		Assert.notNull(permissionOrgModel, "Property 'permissionOrgModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			Boolean checkResult = permissionOrgModel.checkOrgByID(orgID);
			if( checkResult ){
				serviceResult.setMessage("该机构信息被引用");
			}else{
				serviceResult.setMessage("该机构信息未被引用");
			}
			serviceResult.setSuccess(checkResult);
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
	 * 新增机构
	 * @param org 机构信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	@Override
	public ServiceResult<Void> addOrg(PermissionOrgParam org) {
		Assert.notNull(permissionOrgModel, "Property 'permissionOrgModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			
			Boolean existOrgName = permissionOrgModel.checkExistOrgName(org);	//在同一父机构下，检查机构名称是否重复
			if( existOrgName ){
				serviceResult.setSuccess(false);
				serviceResult.setMessage("机构名称重复,新增机构失败");
			} else {
				Boolean existOrgCode = permissionOrgModel.checkExistOrgCode(org);	//在同一父机构下，检查机构编码是否重复
				if(existOrgCode){
					serviceResult.setSuccess(false);
					serviceResult.setMessage("机构编码重复,新增机构失败");
				} else {
					permissionOrgModel.addOrg(org);
					serviceResult.setSuccess(true);
					serviceResult.setMessage("新增机构成功");
				}
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
	 * 修改机构
	 * @param org 机构信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	@Override
	public ServiceResult<Void> updateOrg(PermissionOrgParam org) {
		Assert.notNull(permissionOrgModel, "Property 'permissionOrgModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			if( org.getOrgID() == 1001 ){
				serviceResult.setSuccess(false);
				serviceResult.setMessage("机构树信息不可修改");
				return serviceResult;
			}
			
			Boolean existOrgName = permissionOrgModel.checkExistOrgName(org);	//在同一父机构下，检查机构名称是否重复
			if( existOrgName ){
				serviceResult.setSuccess(false);
				serviceResult.setMessage("机构名称重复,修改机构失败");
			} else {
				Boolean existOrgCode = permissionOrgModel.checkExistOrgCode(org);	//在同一父机构下，检查机构编码是否重复
				if(existOrgCode){
					serviceResult.setSuccess(false);
					serviceResult.setMessage("机构编码重复,修改机构失败");
				} else {
					Boolean updateOrgResult = permissionOrgModel.updateOrg(org);
					if(updateOrgResult){
						serviceResult.setMessage("修改机构成功");
					} else {
						serviceResult.setMessage("修改机构失败");
					}
					serviceResult.setSuccess(updateOrgResult);
				}
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
	 * 根据父机构ID获取机构树
	 * @param id	父机构ID
	 * @return		机构树
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	@Override
	public ServiceResult<List<PermissionOrgParam>> findOrgForTree(Integer parentOrgID) {
		Assert.notNull(permissionOrgModel, "Property 'permissionOrgModel' is required.");
		ServiceResult<List<PermissionOrgParam>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionOrgModel.findOrgForTree(parentOrgID));
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
	 * 根据机构ID获取该机构信息，以及其子孙机构信息
	 * @param orgID 机构ID
	 * @return 机构信息
	 * @author HeJiawang
	 * @date   2016.11.03
	 */
	@Override
	public ServiceResult<List<PermissionOrgParam>> getChildrenOrgByOrgID(Integer orgID) {
		Assert.notNull(permissionOrgModel, "Property 'permissionOrgModel' is required.");
		ServiceResult<List<PermissionOrgParam>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionOrgModel.getChildrenOrgByOrgID(orgID));
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
