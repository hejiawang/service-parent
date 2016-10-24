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
import com.wang.service.param.permission.PermissionElementParam;
import com.wang.service.service.permission.PermissionElementService;
import com.wang.serviceimp.model.permission.PermissionElementModel;

/**
 * 页面元素service imp
 * @author HeJiawang
 * @date   2016.10.24
 */
@Service
public class PermissionElementServiceImp implements PermissionElementService {

	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionElementServiceImp.class);
	
	/**
	 * permissionElementModel
	 */
	@Autowired
	private PermissionElementModel permissionElementModel;
	
	/**
	 * 获取分页页面元素
	 * @param element 页面元素参数
	 * @return 页面元素集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.24
	 */
	@Override
	public ServiceResult<Map<String, Object>> pageElement(PermissionElementParam element) {
		Assert.notNull(permissionElementModel, "Property 'permissionElementModel' is required.");
		ServiceResult<Map<String, Object>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionElementModel.pageElement(element));
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
	 * 新增页面元素
	 * @param  element 页面元素信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.24
	 */
	@Override
	public ServiceResult<Void> addElement(PermissionElementParam element) {
		Assert.notNull(permissionElementModel, "Property 'permissionElementModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			Boolean existName = permissionElementModel.checkExistElementName(element);	//在同一父菜单下，检查名称是否重复
			if(existName){
				serviceResult.setSuccess(false);
				serviceResult.setMessage("名称重复,新增页面元素失败");
			} else {
				permissionElementModel.addElement(element);
				serviceResult.setSuccess(true);
				serviceResult.setMessage("新增页面元素成功");
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
	 * 页面元素查看
	 * @param elementID elementID
	 * @return 信息
	 * @author HeJiawang
	 * @date   2016.10.24
	 */
	@Override
	public ServiceResult<PermissionElementParam> getElementByID(Integer elementID) {
		Assert.notNull(permissionElementModel, "Property 'permissionElementModel' is required.");
		ServiceResult<PermissionElementParam> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionElementModel.getElementByID(elementID));
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
	 * 删除页面元素
	 * @param elementID elementID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.21
	 */
	@Override
	public ServiceResult<Void> deleteElementByID(Integer elementID) {
		Assert.notNull(permissionElementModel, "Property 'permissionElementModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			Boolean deleteResult = permissionElementModel.deleteElementByID(elementID);
			if( deleteResult ){
				serviceResult.setMessage("删除页面元素成功");
			}else{
				serviceResult.setMessage("删除页面元素失败");
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
	 * 修改页面元素
	 * @param element 页面元素信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.24
	 */
	@Override
	public ServiceResult<Void> updateElement(PermissionElementParam element) {
		Assert.notNull(permissionElementModel, "Property 'permissionElementModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			Boolean existName = permissionElementModel.checkExistElementName(element);	//在同一父菜单下，检查名称是否重复
			if(existName){
				serviceResult.setSuccess(false);
				serviceResult.setMessage("页面元素名称重复,修改失败");
			} else {
				permissionElementModel.updateElement(element);
				serviceResult.setSuccess(true);
				serviceResult.setMessage("修改页面元素成功");
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

}
