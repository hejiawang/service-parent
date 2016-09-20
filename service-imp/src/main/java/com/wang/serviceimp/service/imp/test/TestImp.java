package com.wang.serviceimp.service.imp.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.Constants;
import com.wang.core.ServiceResult;
import com.wang.core.exception.BusinessException;
import com.wang.service.entity.test.TestEntity;
import com.wang.service.service.test.TestService;
import com.wang.serviceimp.model.test.TestModel;

/**
 * 框架测试 
 * @author HeJiawang
 * @date   2016.09.14
 */
@Service
public class TestImp implements TestService {

	private final Logger logger = LoggerFactory.getLogger(TestImp.class);
	
	@Autowired 
	private TestModel testModel;
	
	/**
	 * 框架测试——获取实体
	 * @author HeJiawang
	 * @date   2016.09.14
	 * @param  ID Test ID
	 * @return TestEntity
	 */
	@Override
	public ServiceResult<TestEntity> getTestById(Integer ID) {
		Assert.notNull(testModel, "Property 'testModel' is required.");
		
		ServiceResult<TestEntity> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(testModel.getTestById(ID));
		} catch (BusinessException e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setSuccess(false);
		} catch (Exception e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setError(Constants.SERVICE_RESULT_CODE_SYS_ERROR,
			                       Constants.SERVICE_RESULT_EXCEPTION_SYS_ERROR);
			logger.error("发生未知异常!", e);
		}
		return serviceResult;
	}

}
