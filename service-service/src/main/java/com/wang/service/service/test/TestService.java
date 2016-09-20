package com.wang.service.service.test;

import com.wang.core.ServiceResult;
import com.wang.service.entity.test.TestEntity;

/**
 * 框架测试 
 * @author HeJiawang
 * @date   2016.09.14
 */
public interface TestService {

	/**
	 * 框架测试——获取实体
	 * @author HeJiawang
	 * @date   2016.09.14
	 * @param  ID Test ID
	 * @return TestEntity
	 */
	public ServiceResult<TestEntity> getTestById(Integer ID); 
}
