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
import com.wang.service.param.permission.PermissionRankParam;
import com.wang.service.service.permission.PermissionRankService;
import com.wang.serviceimp.model.permission.PermissionRankModel;

/**
 * 职级service imp
 * 
 * @author HeJiawang
 * @date   2016.10.13
 */
@Service
public class PermissionRankServiceImp implements PermissionRankService {

	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionRankServiceImp.class);
	
	/**
	 * permissionpostModel
	 */
	@Autowired
	private PermissionRankModel permissionRankModel;

	/**
	 * 获取分页职级
	 * @param rank 职级参数
	 * @return 职级集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	@Override
	public ServiceResult<Map<String, Object>> pageRank(PermissionRankParam rank) {
		Assert.notNull(permissionRankModel, "Property 'permissionRankModel' is required.");
		ServiceResult<Map<String, Object>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionRankModel.pageRank(rank));
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
	 * 根据父职级ID获取职级树
	 * @param id	父职级ID
	 * @return		职级树
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	@Override
	public ServiceResult<List<PermissionRankParam>> findRankForTree(Integer parentRankID) {
		Assert.notNull(permissionRankModel, "Property 'permissionRankModel' is required.");
		ServiceResult<List<PermissionRankParam>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionRankModel.findRankForTree(parentRankID));
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
	 * 查看职级
	 * @param rankID 职级ID
	 * @return 职级信息
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	@Override
	public ServiceResult<Map<String, Object>> getRankByID(Integer rankID) {
		Assert.notNull(permissionRankModel, "Property 'permissionRankModel' is required.");
		ServiceResult<Map<String, Object>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionRankModel.getRankByID(rankID));
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
	 * 删除职级
	 * @param rankID 职级ID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	@Override
	public ServiceResult<Void> deleteRankByID(Integer rankID) {
		Assert.notNull(permissionRankModel, "Property 'permissionRankModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			if( rankID == 1001 ){
				serviceResult.setSuccess(false);
				serviceResult.setMessage("职级树信息不可删除");
				return serviceResult;
			}
			
			Boolean checkResult = permissionRankModel.checkRankByID(rankID);
			if( checkResult ){
				serviceResult.setSuccess(false);
				serviceResult.setMessage("该职级信息被引用,不可删除");
			}else{
				Boolean deleteResult = permissionRankModel.deleteRankByID(rankID);
				if( deleteResult ){
					serviceResult.setMessage("删除职级成功");
				}else{
					serviceResult.setMessage("删除职级失败");
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
	 * 新增职级
	 * @param rank 职级信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	@Override
	public ServiceResult<Void> addRank(PermissionRankParam rank) {
		Assert.notNull(permissionRankModel, "Property 'permissionRankModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			
			Boolean existName = permissionRankModel.checkExistRankName(rank);	//在同一父职级下，检查职级名称是否重复
			if( existName ){
				serviceResult.setSuccess(false);
				serviceResult.setMessage("职级名称重复,新增职级失败");
			} else {
				permissionRankModel.addRank(rank);
				serviceResult.setSuccess(true);
				serviceResult.setMessage("新增职级成功");
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
	 * 修改职级
	 * @param  rank	职级信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	@Override
	public ServiceResult<Void> updateRank(PermissionRankParam rank) {
		Assert.notNull(permissionRankModel, "Property 'permissionRankModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			if( rank.getRankID() == 1001 ){
				serviceResult.setSuccess(false);
				serviceResult.setMessage("职级树信息不可修改");
				return serviceResult;
			}
			
			Boolean existName = permissionRankModel.checkExistRankName(rank);	//在同一父职级下，检查职级名称是否重复
			if( existName ){
				serviceResult.setSuccess(false);
				serviceResult.setMessage("职级名称重复,修改职级失败");
			} else {
				Boolean updateResult = permissionRankModel.updateRank(rank);
				if(updateResult){
					serviceResult.setMessage("修改职级成功");
				} else {
					serviceResult.setMessage("修改职级失败");
				}
				serviceResult.setSuccess(updateResult);
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
