package com.wang.serviceimp.service.imp.permission;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.Constants;
import com.wang.core.ServiceResult;
import com.wang.core.exception.BusinessException;
import com.wang.service.param.permission.PermissionMenuParam;
import com.wang.service.service.permission.PermissionMenuService;
import com.wang.serviceimp.model.permission.PermissionMenuModel;

/**
 * 菜单service imp
 * @author HeJiawang
 * @date   2016.10.18
 */
@Service
public class PermissionMenuServiceImp implements PermissionMenuService {

	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionMenuServiceImp.class);
	
	/**
	 * permissionMenuModel
	 */
	@Autowired
	private PermissionMenuModel permissionMenuModel;
	
	/**
	 * 获取分页菜单
	 * @param menu 菜单参数
	 * @return 菜单集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.18
	 */
	@Override
	public ServiceResult<Map<String, Object>> pageMenu(PermissionMenuParam menu) {
		Assert.notNull(permissionMenuModel, "Property 'permissionMenuModel' is required.");
		ServiceResult<Map<String, Object>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionMenuModel.pageMenu(menu));
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
	 * 新增菜单
	 * @param  menu 菜单信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.21
	 */
	@Override
	public ServiceResult<Void> addMenu(PermissionMenuParam menu) {
		Assert.notNull(permissionMenuModel, "Property 'permissionMenuModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			Boolean existName = permissionMenuModel.checkExistMenuName(menu);	//在同一父菜单下，检查菜单名称是否重复
			if(existName){
				serviceResult.setSuccess(false);
				serviceResult.setMessage("菜单名称重复,新增菜单失败");
			} else {
				permissionMenuModel.addMenu(menu);
				serviceResult.setSuccess(true);
				serviceResult.setMessage("新增菜单成功");
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
	 * 根据菜单ID获取菜单信息
	 * @param menuID menuID
	 * @return 应用系统信息
	 * @author HeJiawang
	 * @date   2016.10.21
	 */
	@Override
	public ServiceResult<PermissionMenuParam> getMenuByID(Integer menuID) {
		Assert.notNull(permissionMenuModel, "Property 'permissionMenuModel' is required.");
		ServiceResult<PermissionMenuParam> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionMenuModel.getMenuByID(menuID));
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
	 * 删除menu
	 * @param menuID menuID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.21
	 */
	@Override
	public ServiceResult<Void> deleteMenuByID(Integer menuID) {
		Assert.notNull(permissionMenuModel, "Property 'permissionMenuModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			Boolean deleteResult = permissionMenuModel.deleteMenuByID(menuID);
			if( deleteResult ){
				serviceResult.setMessage("删除菜单成功");
			}else{
				serviceResult.setMessage("删除菜单失败");
			}
			serviceResult.setSuccess(deleteResult);
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
	 * 通过资源ID获取菜单信息
	 * @param menuID menuID
	 * @return 应用系统信息
	 * @author HeJiawang
	 * @date   2016.10.21
	 */
	@Override
	public ServiceResult<PermissionMenuParam> getMenuByResourceID(Integer resourceID) {
		Assert.notNull(permissionMenuModel, "Property 'permissionMenuModel' is required.");
		ServiceResult<PermissionMenuParam> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionMenuModel.getMenuByResourceID(resourceID));
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
